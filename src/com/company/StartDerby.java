package com.company;

import java.io.IOException;

public class StartDerby {
//
    public static void main(String[] args) {

        startDerby();

    }

    public static void startDerby(){
        Runtime rt = Runtime.getRuntime();
        String path = "\"C:\\Program Files\\Java\\jdk1.8.0_144\\db\\bin\\startNetworkServer.bat\"";
        String quotes = "\"\"";

        System.out.println(quotes);

        //"C:\\Program Files\\Java\\jdk1.8.0_144\\db\\bin\\startNetworkServer.bat"

        try{

           Process proc = rt.exec("cmd /c start \"\" cmd.exe /K \"C:\\Program Files\\Java\\jdk1.8.0_144\\db\\bin\\startNetworkServer.bat\"");

           // Process proc = rt.exec("cmd /min start  cmd.exe /K ");

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
