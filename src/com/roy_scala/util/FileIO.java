package com.roy_scala.util;
/**
 * Created by Roy on 10/22/2015.
 */

import java.io.*;

public class FileIO {
    public String in;
    public String out;
    public FileIO(String f_in, String f_out){
        // initialize FileIO object, assign attribute values
        in = f_in;
        out = f_out;
    }

    public String read_f() {
        try {
            File fileDir = new File(this.in);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF8"));
            String text = "";
            String text_buffer;
            while ((text_buffer = br.readLine()) != null) {
                text = text + text_buffer + "\n";
            }
            br.close();
            return text;
        }
        catch (UnsupportedEncodingException e)
        {
            System.out.println(e.getMessage());
            return "";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return "";
        }
    }

    public int write_f(String PoS){
        try {
            File fileDir = new File(this.out);

            BufferedWriter br = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(fileDir), "UTF8"));

            br.write(PoS);
            br.close();
            return 0;
        }

        catch (UnsupportedEncodingException e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}