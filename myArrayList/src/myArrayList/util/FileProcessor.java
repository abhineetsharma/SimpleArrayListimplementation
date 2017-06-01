package myArrayList.util;

import java.io.*;


public class FileProcessor{;
    private File file;
    private FileInputStream fstream;
    private BufferedReader br;
    public FileProcessor(){
        br=null;
        String path = String.format("%s/myArrayList/%s",System.getProperty("user.dir"),"input.txt");
        //System.out.println(path);
        file = new File(path);
        //System.out.println( System.getProperty("user.dir"));
        if(file.exists() && !file.isDirectory()){

            try{
            fstream = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(fstream));
            }catch (IOException ex){
                if(br!=null) try {
                    br.close();
                } catch (IOException e) {

                }
            }
        }
        else{
            System.out.println("File not found");
        }
    }

    public String readLine(){

        String strLine;
        if(file.exists() && !file.isDirectory()){

            try {
                if ((strLine = br.readLine()) != null)   {
                    return strLine;
                }else{
                    br.close();
                    return  null;
                }
            } catch (IOException e) {

            }
        }
        return null;
    }
	
}