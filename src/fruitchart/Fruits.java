/**
 * Fruit Chart Main
 * david.qwk@gmail.com
 * 
 * This is an applet version. To run this on Processing IDE, 
 * remove the PApplet related parts and access specifiers.
 * 
 */

package fruitchart;

import java.util.ArrayList;
import processing.core.PApplet;

public class Fruits extends PApplet {

	private static final long serialVersionUID = -3431077856221134227L;
	FruitChart chart;
	ArrayList<String> allFruits = new ArrayList<String>();
	 
	protected static int width = 800;
	protected static int height = 600;
	
	static int[] barColors = new int[3];
	
	String[] headers;
	
	int dataMin = 0;
	int dataMax;
	
	int yLabelAreaWidth;
	
	int interval;
	
	public void setup() {
		size(width, height);
		
		//color set
		barColors[0] = color(232,44,12);
		barColors[1] = color(240,132,12);
		barColors[2] = color(85,166,222);
		
		//fruit data
		allFruits.add("category,apples,oranges,bananas");
		allFruits.add("weight,200,120,450");
		allFruits.add("sales,320,85,198");
		allFruits.add("profit,130,33,99");
		
		//instance of FruitChart
		chart = new FruitChart(this);
		
		chart.setData(allFruits);
		//y-axis label width
		yLabelAreaWidth = chart.getYLabelArea(100);		
		
		//data headers
		headers = chart.getHeaders(allFruits.get(0));
		
		//min data, max data
		dataMin = chart.getMinData(allFruits);
		dataMax = chart.getMaxData(allFruits);
		
		//tick interval
		interval = chart.getInterval(50);
		
	}

	public void draw() {
		noLoop();//does not iterate the pieces inside draw()

		//draw x-axis at the bottom of the chart as big as the width
		//with tick-interval 50
		chart.drawAxis("x","bottom",new int[] {0,width},interval);
		
		//draw another x-axis on the top side of the chart
		chart.drawAxis("x","top",new int[] {0,width},interval);
		
		//draw y-axis on the left side of the chart
		chart.drawAxis("y","left",new int[] {0,height},0);
		
		//draw bars with the fruit data
		chart.drawBar(allFruits);
	
	}
	
}
