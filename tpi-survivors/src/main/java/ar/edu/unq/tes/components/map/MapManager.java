package ar.edu.unq.tes.components.map;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import ar.edu.unq.ts.application.TSGameComponent;
import ar.edu.unq.ts.scenes.ShooterLevelScene;

import com.uqbar.vainilla.appearances.Sprite;

public class MapManager {

	private int DESX = 0;
	private int DESY = 0;
	

	private int imageSize = 32;
	private int scale = 1;
	
	
	private int yPositionsSize = 0;
	private int xPositionsSize = 0;
	
	
	private int yShoter = 0;
	private int xShoter = 0;
	
	

	private MapPosition[][] matrix;

	public void load(String xml, ShooterLevelScene shooterLevelScene) {
		BufferedImage imageStore[] = new BufferedImage[50];
		this.loadDataFrom(xml);
		this.loadImagesToStore(imageStore);
		BufferedImage mapCanvas = new BufferedImage(3100, 3100, BufferedImage.TYPE_INT_ARGB);
		this.fillCanvas(mapCanvas, imageStore);
		shooterLevelScene.addComponent(new TSGameComponent(new Sprite(mapCanvas), DESX, DESY));
	}

	private void loadDataFrom(String xml) {
		InputStream xmlAsResource = ClassLoader.class.getResourceAsStream("/maps/" + xml + ".xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlAsResource);
			doc.getDocumentElement().normalize();
			this.loadArray(doc);
			this.loadAtributes(doc);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadAtributes(Document doc) {
		NodeList nList1 = doc.getElementsByTagName("img-size");
		this.imageSize = Integer.valueOf(nList1.item(0).getTextContent());		

		NodeList nList2 = doc.getElementsByTagName("scale");
		this.scale = Integer.valueOf(nList2.item(0).getTextContent());
		
		NodeList cameralList = doc.getElementsByTagName("shoter-positions");
		String[] positions = (cameralList.item(0).getTextContent()).split(",");
		this.xShoter = Integer.valueOf(positions[0])*scale*imageSize;
		this.yShoter = Integer.valueOf(positions[1])*scale*imageSize;
	}

	private void loadArray(Document doc) {
		NodeList nList = doc.getElementsByTagName("row");
		if(nList.getLength() > 0){
			this.initializeMatrix(nList);			
			for (int y = 0, size = nList.getLength(); y < size; y++) {
				String[] xEs = nList.item(y).getTextContent().split(",");
				for (int x = 0; x < xEs.length; x++) {
					this.matrix[y][x] = new MapPosition(xEs[x]);
				}
			}
		}
		else{
			throw new RuntimeException("Can not find ´row´ attribute");
		}
	}

	private void initializeMatrix(NodeList nList) {
		this.yPositionsSize = nList.getLength();
		this.xPositionsSize = nList.item(0).getTextContent().split(",").length;		
		this.matrix = new MapPosition[yPositionsSize][xPositionsSize];
	}
	

	private void fillCanvas( BufferedImage mapCanvas, BufferedImage[] imageStore) {
		Graphics graphic = mapCanvas.getGraphics();
		for (int y = 0; y < this.yPositionsSize; y++) {
			for (int x = 0; x < this.xPositionsSize; x++) {
				MapPosition mapPosition = matrix[y][x];
				graphic.drawImage(imageStore[mapPosition.imgIndex], x*imageSize*scale, y*imageSize*scale, null);
			}
		}		
	}

	private void loadImagesToStore(BufferedImage[] imageStore) {
		try {
			AffineTransform scaleTransform = AffineTransform.getScaleInstance(scale, scale);
			AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);

			for (int i = 0; i < imageStore.length; i++) {
				BufferedImage imageTemp;
				imageTemp = ImageIO.read(ClassLoader.getSystemResource("images/map/map_" + this.completeIndex(i) + ".png"));
				imageStore[i] = bilinearScaleOp.filter(imageTemp, new BufferedImage(imageSize*scale, imageSize*scale, imageTemp.getType()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String completeIndex(int index) {
		if (index < 10) {
			return "0" + index;
		}
		return String.valueOf(index);
	}

	public int getYShooter() {
		return yShoter;
	}


	public int getXShooter() {
		return xShoter;
	}

	public boolean isPosiblePosition(double x, double y) {
		//System.out.println("y" + ((int) Math.floor(y/(imageSize*scale))));
		//return false;
		return matrix[(int) Math.floor(y/(imageSize*scale))][(int) Math.floor(x/(imageSize*scale))].imgIndex < 12;
	}


	
	

}
