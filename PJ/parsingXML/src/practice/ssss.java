package practice;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.swing.JLabel;



public final class ssss extends JTree{

    DefaultTreeModel dtModel=null;
    /**
     * @wbp.nonvisual location=323,34
     */
    private final JLabel ceas = new JLabel("New label");
    /**
     * @wbp.nonvisual location=323,24
     */
   
   
   
    public ssss(String filePath){
        if(filePath!=null)
        setPath(filePath);
    }
    public void error(SAXParseException e) throws SAXException {
    	throw new SAXException("Error:"+e.getMessage());
    }
    
    	
    public void fatalError(SAXParseException e) throws SAXException {
    	throw new SAXException("Fatal Error:"+e.getMessage());
    }
    	
    public void warning(SAXParseException e) throws SAXException {
    	System.out.println("Warning"+e.getMessage());
    	}

    public void setPath(String filePath){
        Node root = null;
        /*
            Parcurge fisierul xml
        */
        try {
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(filePath);
            root = (Node) doc.getDocumentElement();
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        /*
           bagam modelul in DTM
        */
        if(root!=null){
            dtModel= new DefaultTreeModel(builtTreeNode(root));
            this.setModel(dtModel);
        }
    }

   
    private DefaultMutableTreeNode builtTreeNode(Node root){
        DefaultMutableTreeNode dmtNode;

        dmtNode = new DefaultMutableTreeNode(root.getNodeName());
            NodeList nodeList = root.getChildNodes();
            for (int count = 0; count < nodeList.getLength(); count++) {
                Node tempNode = nodeList.item(count);
                //parcurge nodurile de la radacina
                if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                   if (tempNode.hasChildNodes()) {
                        //parcurge elementele din noduri
                        dmtNode.add(builtTreeNode(tempNode));
                    }
                }
            }
        return dmtNode;
    }
static Timer time;
    public static void main(String[] args) {
      
        JFrame myFrame = new JFrame();
        myFrame.setTitle("XML parser Tree");
        myFrame.setSize(300, 500);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);
        JPanel pan = new JPanel(new GridLayout(1, 1));
       
        final ssss myTree = new ssss(null);
        
        myFrame.getContentPane().add(new JScrollPane(myTree));
        JLabel ceas=new JLabel("ceas");
        
       ActionListener actionListener=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Date date=new Date();
			DateFormat timeFormat=new SimpleDateFormat("HH:mm:ss");
			String time=timeFormat.format(date);
			ceas.setText("Ora curenta: "+time);
		}
	};
	time=new Timer(1000,actionListener);
	time.setInitialDelay(0);
	time.start();
	
        JButton button = new JButton("Alege Fisierul");
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser chooser = new JFileChooser("F:\\univer\\univer\\java\\teme\\Tema8PJ\\src\\ProcesareXML");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("XML file", "xml");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    myTree.setPath(chooser.getSelectedFile().getAbsolutePath());
                }
            }
        });
        pan.add(button);
        pan.add(ceas);
        myFrame.getContentPane().add(pan,BorderLayout.SOUTH);
        myFrame.setVisible(true);
    }
}