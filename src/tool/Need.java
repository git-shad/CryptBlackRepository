package tool;

public class Need {
    Need(){}//default constractor
    public static void cmd(String command) {
        try {
            new ProcessBuilder("cmd", "/c", command).
                    inheritIO()
                    .start()
                    .waitFor();
        } catch (java.io.IOException | java.lang.InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static Need progressAni(home nt,int wait){
        var need = new Need();
        try{
            need = progressAni(nt);
            Thread.sleep(wait);//delay 
        }catch(Exception ex){}
        return need;
    }
    
    public static Need progressAni(home nt){
        return new Need(new hmm(){
            private boolean running = true;
            @Override
            public void run(){
                try{
                    var ico = "─\\|/".toCharArray();
                    var id = 0;
                    
                    while(running){
                        nt.terminal.setText((nt.outText+ico[id]));
                        if(id == 3) {
                            id = 0;
                        }else ++id;
                        Thread.sleep(50);
                    }
                }catch(InterruptedException ex){
                    //ignored
                }
            }
            
            @Override
            public void stop() {
                nt.terminal.setText((nt.outText += String.format("done.." )));
                running = false;
            }
        });
    }
    
    public static String byteSizing(int length){
        var displaySize = "";
        if(length <= 1024){
            displaySize = length+"";
        }else if(length <= 1024*1024){
            displaySize = String.format("%.2fkb", ((double)length/1024));
        }else if(length <= ((1024*1024)*1024)){
            displaySize = String.format("%.2fmb", ((double)length/(1024*1024)));
        }else if(length <= (((1024*1024)*1024)*1024)){
            displaySize = String.format("%.2fgb", ((double)length/(1024*1024)));
        }
        return displaySize;
    }
    
    private boolean running = true;
    private Thread thread = null;
    private hmm code = null;
    public Need(hmm code){
        this.code = code;
        thread = new Thread(code);
        thread.start();
    }
    
    public void stop(){
        code.stop();
    }
    
   
    
}

interface hmm extends Runnable{
    void stop();
}
