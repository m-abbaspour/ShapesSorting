package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

import problemdomain.Shape;
import sortmethods.BubbleSort;
import sortmethods.HeapSort;
import sortmethods.InsertionSort;
import sortmethods.MergeSort;
import sortmethods.QuickSort;
import utilities.BaseAreaCompare;
import utilities.VolumeCompare;


public class Sort {
	public static void main(String[] args) {
		String fileName = "";
        String sort = "";
        String orderBy = "";
        for (String arg : args) {
            arg = arg.toLowerCase();
            if (arg.startsWith("-f")) {
                fileName = arg.substring(2).replace("\"", ""); // removing " from the string
                if (fileName.contains("c:\\temp\\")) {
                	fileName= fileName.substring(fileName.lastIndexOf("\\"), fileName.length());
                } 
                if(!fileName.contains("res/")) {
                	fileName = "res/" + fileName;
				}
            }else if (arg.startsWith("-s"))
                sort = arg.substring(2);
            else if (arg.startsWith("-t"))
                orderBy = arg.substring(2);

        }
        
        File f = new File(fileName);
        if (!f.exists()) {
            System.out.println("file not found:" + fileName);
            return;
        }

        if (!orderBy.equals("v") && !orderBy.equals("a") && !orderBy.equals("h")) {
            System.out.println("-ta  or -tv or -th    are acceptable!  v for volume, h for height, a for base area");
            return;
        }

        if (!sort.equals("b") && !sort.equals("s") && !sort.equals("q")
                && !sort.equals("i") && !sort.equals("m") && !sort.equals("z")) {
            System.out.println("-s[b | s | i | m | q | z] are acceptable! b is bubble, s is selection," +
                    " i is insertion, m is merge, q is quick, and my choice of sorting algorithm is z.");
            return;
        }
        
        Shape[] g3dArray = null;
        try {
			g3dArray = readFormFile(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}
        System.out.println("Sort Parameters are \"sort=" + sort + " orderBy=" + orderBy + " fileName=" + fileName + "\"");
        Comparator vc = null;
        if (orderBy.equals("v"))
            vc = new VolumeCompare();
        else if (orderBy.equals("a"))
            vc = new BaseAreaCompare();
        Date startDate = new Date();
        System.out.println("start time:" + startDate);
        if (sort.equals('z'))
                HeapSort.sort(g3dArray, vc);
        else if (sort.equals('b'))
                BubbleSort.sort(g3dArray, vc);
        else if (sort.equals('i'))
                InsertionSort.sort(g3dArray, vc);
        else if (sort.equals('q'))
                QuickSort.sort(g3dArray, vc);
        else if (sort.equals('m'))
                MergeSort.sort(g3dArray, vc);
        else
            Arrays.sort(g3dArray, vc);
        Date endDate = new Date();
        printShape(g3dArray);
        System.out.println("stop time:" + endDate);
        System.out.println("time consumed:" + (endDate.getTime() - startDate.getTime()) + " ms");

    }
	
	static Shape[] readFormFile(String fileName) throws FileNotFoundException {
        File myObj = new File(fileName);
        Scanner myReader = new Scanner(myObj);
        int noOfObj = myReader.nextInt();
        Shape[] g3dArray = new Shape[noOfObj];
        for (int i = 0; i < noOfObj && myReader.hasNext(); i++) {
            String objName = myReader.next();
            double firtDouble   = myReader.nextDouble();
            double secondDouble = myReader.nextDouble();
            try {
                Class aClass = Class.forName("problemdomain."+objName);    // Load Class
                Object o = aClass.getConstructor(new Class[] {double.class , double.class} )   // find Constructor
                                      .newInstance(firtDouble,secondDouble);   // create object
                g3dArray[i] = (Shape) o;  // add to array

            } catch (Exception e) {
                System.out.println("Error - object type not found: " + objName);
            }
        }
        myReader.close();
        return g3dArray;
    }
	
	
	static void printShape(Shape[] g3D) {
	    System.out.println(g3D[0]);
	    for (int i = 999; i < g3D.length; i += 1000) {
	        System.out.println(g3D[i].toString());
	    }
	    System.out.println(g3D[g3D.length - 1]);
	}
}
