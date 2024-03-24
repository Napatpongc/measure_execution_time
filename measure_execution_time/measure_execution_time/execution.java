import java.text.DecimalFormat;
class execution {
    private double numtime; ;
    public execution(){ 
    }

    public void setnumtime (double numtime){
        this.numtime=numtime;
    }

    public String getnumtime(){
        DecimalFormat decimalFormat = new DecimalFormat("#0.000");
        String snumtime = decimalFormat.format(numtime);
        return snumtime;
    }

    public long program() {
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            for(int j = 0; j < 5; j++){
                System.out.println(i);   
            }
        }
        long end = System.nanoTime();
        return end - start;
    }

    public void gen(){
        long totaltime = program();
        double second = (double) totaltime / 1000000000; 
        setnumtime(second);
    } 
}
