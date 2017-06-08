package myArrayList.util;

import java.io.File;
import java.io.Writer;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class Results implements StdoutDisplayInterface, FileDisplayInterface {

    private StringBuilder sbr;
    private String outputPath;

    public Results(String path) {
        this.setSbr(new StringBuilder());
        this.setOutputPath(path);
    }

    private String getOutputPath() {
        return outputPath;
    }

    private void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    private String getString() {
        return getSbr().toString().trim();
    }

    private StringBuilder getSbr() {
        return sbr;
    }

    private void setSbr(StringBuilder sbr) {
        this.sbr = sbr;
    }

    public void storeNewResult(Object obj) {
        String str = obj.toString();
        str = String.format("%s%s",str,"\n");
        StringBuilder sb = getSbr();
        sb.append(str);
        setSbr(sb);
    }

    @Override
    public void writeToStdout() {
        System.out.println(getString());
    }

    @Override
    public void writeToFile() {

        File file ;
        try {

            file = new File(getOutputPath());

            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(getOutputPath()), "utf-8"))) {
                String str1 = getString();
                writer.write(str1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error in printing into the output file");
            System.exit(0);
        }


    }

    @Override
    public String toString(){
        String className = this.getClass().getName();
        String description = "This class has a data structure as private data member that store Strings and it implements FileDisplayInterface and StdoutDisplayInterface";
        String str = String.format("\nClass : %s\nMethod toString()\nDescription : %s\nPrivate variable :\noutputPath value is : %s\nsbr value is: %s\n",className,description ,getOutputPath(),getSbr().toString());
        System.out.println(str);
        return str;
    }
}