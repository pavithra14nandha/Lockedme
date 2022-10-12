package com.lockedme;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Files2 {
	
	public static void main(String[] args) throws IOException {
		Welcomescreen.welcome();
	
		Scanner sc= new Scanner(System.in);
		String path="C:\\files\\";
		while(true) {
			System.out.println("1 : DISPLAY \n2 : MENU  \n3 : EXIT");
			int display=sc.nextInt();

			switch(display)
			{
			case 1:

				File f=new File(path);
				File filenames[]=f.listFiles();
				System.out.println("The Files in the Directory are :");
				System.out.println("=================================");
				for(File ff: filenames) {
					System.out.println(ff.getName());
				}
				System.out.println("================================");
				
				break;
			case 2:
				boolean value=true;
				
				while(value)
				{
					System.out.println("1 : ADD FILE \n2 : DELETE file \n3 : SEARCH file \n4 : EXIT");
					int menu=sc.nextInt();

					switch(menu)
					{
					case 1:


						System.out.println("Enter The File in the Directory of "+path);
						String filename=sc.next();
						//File
						File f1=new File(path+filename);
						//create a new file
						boolean b=f1.createNewFile();
						if(b!=true) {
							System.out.println("file not created");
						}
						else {
							System.out.println("file created in the path " +path);
							System.out.println("=======================================");
							System.out.println("enter the data into the file");
							FileWriter file= new FileWriter(filename,true);
							String data1=sc.next()+sc.nextLine();
							System.out.println(data1);
							file.write(data1);
						}
						break;
					case 2:
						System.out.println("Enter The File in the Directory of "+path);
						String filename2=sc.next();
						File f3=new File(path+filename2);
						boolean b1=f3.getAbsoluteFile().delete();
						
						if(b1==true)
						{
							System.out.println("File has deleted");
							System.out.println("=================");
						}
						else
						{
							System.out.println("404 : File not Found");
							System.out.println("=====================");
						}
						break;
					case 3:

						System.out.println("Enter the File in the Directory of "+path);
						System.out.println("----------------------------------------------");
						String filename1=sc.next();
						//File
						File f2=new File(path);
						File filenames2[]=f2.listFiles();
						int flag=0;
						for(File ff: filenames2) {
							if(ff.getCanonicalFile().getName().equals(filename1))
							{
							
								flag=1;
								break;
							}
							else {
								flag=0;
							}
						}
						if(flag==1) {
							System.out.println("The File is Found");
							System.out.println("=============================================");
							
						}
						else {
							System.out.println("404 : File not Found");
							System.out.println("=====================");
						}
						break;	
					case 4:
						System.out.println("   Exit   ");
						System.out.println("**********");
						value=false;
					default  :
						System.out.println("Please, Enter the correct option");
					}

				}
				break;	
			case 3:
				System.out.println("   EXIT   ");
				System.out.println("**********");
				System.exit(0);
				break;
				default:
					System.out.println("Please, Enter the correct option");
			}
		}
	}
}

