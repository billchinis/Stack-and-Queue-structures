import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class TagMatching {
	static StringStackImpl stack = new StringStackImpl(); //Stack
	static String path = null; //Path of file

	
	static boolean emptyFile = true;//changes as soon as first tag is found 
	
	public static void main(String[] args){
		path = args[0];//path is given by the user though a cmd command
		
		readFile();//file is read using readFile
		
		if(!emptyFile){
			if(stack.isEmpty()){
				System.out.println("Tags are good on this file!");//Empty stack means tag are matching exactly as they should be
			}
			else{
				System.out.println("Tags are bad on this file!");//One ore more objects in stack suggest tags are not matching correctly or at all
			}
		}else{
			System.out.println("The file is empty!");
		}
	}
	
	public static void readFile(){
		
		File f = null;
		BufferedReader reader = null;
		
		String line;
		
		try{ //creates a new File
			f = new File(path);
		} catch (NullPointerException e) {
			System.err.println("File not found");
		}
		
		try{ //creates a new BufferedReader
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		} catch (FileNotFoundException e) {
			System.err.println("Error opening file!");
		}
		
		try{
			line = reader.readLine();
			
			while (line!=null){//reads whole file
				int char1 = 0;
				
				while(char1!=line.length()){//reads every letter of the line
					if( line.charAt(char1) == '<' ){//char1 searches for the beginning of every tag
						//opening tags here
						if( line.charAt(char1+1) != '/' ){	
							
							int char2 = char1;
							
							while(line.charAt(char2) != '>'){
								char2++;//moves a letter forward
							}
							stack.push(line.substring(char1, char2 + 1));//tag is added to stack
							
							if(emptyFile) emptyFile = false;
							//stack.printStack(System.out); //can be used to demonstrate stack usage step by step
							//System.out.println("----------------------");
						}
						//closing tags here
						else if( line.charAt(char1+1) == '/' ){	
							int char2 = char1;
							
							while(line.charAt(char2) != '>'){//char2 searches for end of tag
								char2++;
							}
							
							String tag = line.substring(char1, char2+1);
							if(!stack.isEmpty()){
								if(tag.replaceAll("/", "").equals(stack.peek())){//tag is not added to stack and stack top is popped if tags match
									stack.pop();
								}
								else{
									stack.push(tag);//tag is added to stack	if it doesn't match opening tag on the top of the stack								
								}
							}
							else{
								stack.push(tag);//tag is added to stack is stack is empty
							}
							//stack.printStack(System.out); //can be used to demonstrate stack usage step by step
							//System.out.println("----------------------");
						
						}
					}
					
					char1++;//moves a letter forward
				}
				
				line = reader.readLine();//moves a line down
			}	
		}
		catch (IOException e) {
			System.out.println("Error reading file!");
		}
	}
}
