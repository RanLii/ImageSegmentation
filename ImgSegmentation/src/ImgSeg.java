import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.FileDialog;



public class ImgSeg {

	private JFrame frmImageSegmentation;
	private JPanel panel;
	private JPanel panel_1;
	private JTabbedPane tabbedPane;
	private JLabel lblOriginal;
    private JLabel lblSegmentation;
	private JLabel lblNumberOfClusters;
	private JTextField NumCluster;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnL5E5, rdbtnL5R5, rdbtnE5S5, rdbtnS5S5, rdbtnR5R5, rdbtnL5S5, rdbtnE5E5, rdbtnE5R5, rdbtnS5R5;
	private JButton btnGo;
	
	private JMenuItem mntmGrayScaleImage;
	
	
	//...
	
	private FileDialog openDia, saveDia;
    private File file;
    
    private Image img;
    private int img_type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImgSeg window = new ImgSeg();
					window.frmImageSegmentation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ImgSeg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImageSegmentation = new JFrame();
		frmImageSegmentation.setTitle("Image Segmentation");
		frmImageSegmentation.setBounds(100, 100, 889, 632);
		frmImageSegmentation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImageSegmentation.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 601, 550);
		frmImageSegmentation.getContentPane().add(panel);
		panel.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 581, 528);
		panel.add(tabbedPane);
		
		lblOriginal = new JLabel("Original");
		tabbedPane.addTab("Original", null, lblOriginal, null);
		
		lblSegmentation = new JLabel("Segmentation");
		tabbedPane.addTab("Segmentation", null, lblSegmentation, null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(621, 11, 244, 550);
		frmImageSegmentation.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblNumberOfClusters = new JLabel("Number of Clusters:");
		lblNumberOfClusters.setBounds(10, 11, 126, 14);
		panel_1.add(lblNumberOfClusters);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 36, 216, 2);
		panel_1.add(separator_1);
		
		JLabel lblFeatureSelection = new JLabel("Feature Selection:");
		lblFeatureSelection.setBounds(10, 45, 126, 14);
		panel_1.add(lblFeatureSelection);
		
		rdbtnL5E5 = new JRadioButton("L5E5");
		buttonGroup.add(rdbtnL5E5);
		rdbtnL5E5.setBounds(6, 66, 109, 23);
		panel_1.add(rdbtnL5E5);
		
		rdbtnL5R5 = new JRadioButton("L5R5");
		buttonGroup.add(rdbtnL5R5);
		rdbtnL5R5.setBounds(6, 92, 109, 23);
		panel_1.add(rdbtnL5R5);
		
		rdbtnE5S5 = new JRadioButton("E5S5");
		buttonGroup.add(rdbtnE5S5);
		rdbtnE5S5.setBounds(117, 66, 109, 23);
		panel_1.add(rdbtnE5S5);
		
		rdbtnS5S5 = new JRadioButton("S5S5");
		buttonGroup.add(rdbtnS5S5);
		rdbtnS5S5.setBounds(117, 92, 109, 23);
		panel_1.add(rdbtnS5S5);
		
		rdbtnR5R5 = new JRadioButton("R5R5");
		buttonGroup.add(rdbtnR5R5);
		rdbtnR5R5.setBounds(6, 118, 109, 23);
		panel_1.add(rdbtnR5R5);
		
		rdbtnL5S5 = new JRadioButton("L5S5");
		buttonGroup.add(rdbtnL5S5);
		rdbtnL5S5.setBounds(117, 118, 109, 23);
		panel_1.add(rdbtnL5S5);
		
		rdbtnE5E5 = new JRadioButton("E5E5");
		buttonGroup.add(rdbtnE5E5);
		rdbtnE5E5.setBounds(6, 144, 109, 23);
		panel_1.add(rdbtnE5E5);
		
		rdbtnE5R5 = new JRadioButton("E5R5");
		buttonGroup.add(rdbtnE5R5);
		rdbtnE5R5.setBounds(117, 144, 109, 23);
		panel_1.add(rdbtnE5R5);
		
		rdbtnS5R5 = new JRadioButton("S5R5");
		buttonGroup.add(rdbtnS5R5);
		rdbtnS5R5.setBounds(6, 170, 109, 23);
		panel_1.add(rdbtnS5R5);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 200, 216, 2);
		panel_1.add(separator_2);
		
		JLabel lblClusterTechnique = new JLabel("Cluster Technique:");
		lblClusterTechnique.setBounds(10, 213, 126, 14);
		panel_1.add(lblClusterTechnique);
		
		NumCluster = new JTextField();
		NumCluster.setBounds(140, 8, 86, 20);
		panel_1.add(NumCluster);
		NumCluster.setColumns(10);
		
		JRadioButton rdbtnKmeans = new JRadioButton("KMeans");
		rdbtnKmeans.setBounds(117, 209, 109, 23);
		panel_1.add(rdbtnKmeans);
		//...
		
		btnGo = new JButton("GO");
		btnGo.setBounds(140, 516, 89, 23);
		panel_1.add(btnGo);
		
		JMenuBar menuBar = new JMenuBar();
		frmImageSegmentation.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File    ");
		menuBar.add(mnFile);
		
		JMenu mnOpenFile = new JMenu("Open File...");
		mnFile.add(mnOpenFile);
		
		mntmGrayScaleImage = new JMenuItem("Gray Scale Image");
		
		mnOpenFile.add(mntmGrayScaleImage);
		
		JMenuItem mntmColorImage = new JMenuItem("Color Image");
		mnOpenFile.add(mntmColorImage);
		
		JMenuItem mntmSaveFile = new JMenuItem("Save File...");
		mnFile.add(mntmSaveFile);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		        System.exit(0);
		    }
		});
		mnFile.add(mntmExit);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmAboutImageSegmentation = new JMenuItem("About Image Segmentation");
		mnAbout.add(mntmAboutImageSegmentation);
		
		//...
		openDia = new FileDialog(frmImageSegmentation, "Open", FileDialog.LOAD);
        saveDia = new FileDialog(frmImageSegmentation, "Save", FileDialog.SAVE);
        
        myEvent();
        
        
	}
	
	
	private void myEvent() {
	    
	    mntmGrayScaleImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                img_type = 0;
                
                
                openDia.setVisible(true);
                
                String dirpath = openDia.getDirectory();
                String fileName = openDia.getFile();
                
                if (dirpath == null || fileName == null)
                    return;
                else
                    lblOriginal.setText(null);
                
                String fileLocation = dirpath.concat(fileName);
                System.out.println(fileLocation);

                img = new Image(fileLocation, img_type);
                file = new File(dirpath, fileName);

                //frame.getContentPane().add(lblOriginal);
                lblOriginal.setIcon(new ImageIcon(img.getImage()));
            }
        });
	    
	    
	}
	
	
}
