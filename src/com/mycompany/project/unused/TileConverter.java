package com.mycompany.project.unused;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class TileConverter {
   
    public static void convertSVG(String svgPath, String tilePath, float left, float top, float width, float height){
        try{
            float sideLength;
            float quadTop;
            float quadLeft;
           
            if(width>height){
                sideLength = width;
                quadLeft = left;
                quadTop = top - (width-height)/2;
            }else{
                sideLength = height;
                quadLeft = left - (height-width)/2;
                quadTop = top;
            }
           
           
            // Parse the barChart.svg file into a Document.
            String parser = XMLResourceDescriptor.getXMLParserClassName();
            SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
            File fi = new File(svgPath);
            Document doc = f.createDocument(fi.toURI().toString());

            Element svg = doc.getDocumentElement();

            // Make the text look nice.
            svg.setAttributeNS(null, "text-rendering", "geometricPrecision");
           
            // revome onload
            svg.removeAttribute("onload");
           
            // remove script
            for (Node n = svg.getLastChild(); n != null; n = n.getPreviousSibling()){
                if (n.getNodeName().equals("defs")){
                    for (Node m = n.getLastChild(); m != null; m = m.getPreviousSibling()){
                        if (m.getNodeName().equals("script")){
                            n.removeChild(m);
                        }
                    }
                    break;
                }
            }

            // Create a JPEG transcoder
            //JPEGTranscoder t = new JPEGTranscoder();
            PNGTranscoder t = new PNGTranscoder();
           
            // Set the transcoding hints.
            t.addTranscodingHint(PNGTranscoder.KEY_WIDTH, new Float(256.0));
            t.addTranscodingHint(PNGTranscoder.KEY_HEIGHT, new Float(256.0));
           
            // remove unwanted layers
            Node view = null;
            String[] remove = {"IdFuerNull" , "A_SANITAEREINRICHTUNG", "RC", "HAUPTSTRECKE_GRUEN", "VERBINDUNGSSTRECKE_BLAU", "NEBENSTRECKE_ROT", "TREPPENBLOCK_LILA", "NEBENSTRECKE"};
            Arrays.sort(remove);
            ArrayList<Element> layersToRemove = new ArrayList<Element>();
            for (Node n = svg.getLastChild(); n != null; n = n.getPreviousSibling()){
                if (n.getNodeName().equals("g")){
                    view = n;
                    for (Node m = n.getLastChild(); m != null; m = m.getPreviousSibling()){
                        if (m!=null && m instanceof Element && ((Element)m).getAttribute("class").equals("layer")){
                            if(Arrays.binarySearch(remove, ((Element)m).getAttribute("id"))>=0){
                                layersToRemove.add((Element)m);
                            }
                        }
                    }
                    break;
                }
            }
            for(Element e: layersToRemove){
                view.removeChild(e);
            }

            File tileFolder = new File(tilePath);
            tileFolder.mkdir();
           
            for(int zoom=0; zoom<5; zoom++){
                System.out.println("zoom = " + zoom);
                File zoomFolder  = new File(tilePath + zoom);
                zoomFolder.mkdir();
                double s = sideLength / Math.pow(2, zoom);
                for(int x=0; x<Math.pow(2, zoom); x++){
                    System.out.println("\tx = " + x);
                    File xFolder  = new File(tilePath + zoom + "/" + x);
                    xFolder.mkdir();
                    double l = quadLeft + x*s;
                    for(int y=0; y<Math.pow(2, zoom); y++){
                        System.out.println("\t\ty = " + y);
                        double to = quadTop + y*s;
                       
                        // Change the document viewBox.
                        svg.setAttributeNS(null, "viewBox", l + " " + to + " " + s + " " + s);
                       
                        // Create the transcoder input.
                        TranscoderInput input = new TranscoderInput(doc);

                        // Create the transcoder output.
                        OutputStream ostream = new FileOutputStream(tilePath + zoom + "/" + x + "/" + y + ".png");
                        TranscoderOutput output = new TranscoderOutput(ostream);

                        // Save the image.
                        t.transcode(input, output);
                       
                        // Flush and close the stream.
                        ostream.flush();
                        ostream.close();
                    }
                }
            }
           
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String tp = "./WebContent/WEB-INF/tiles/U/";
        convertSVG("./svg/new/uebersicht_angepasst.svg", tp, 0, -260, 380, 260);

    }

} 