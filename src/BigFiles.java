import java.io.File;

public class BigFiles {
public static long THRESHOLD = 1000000L; // one million bytes
    
    public static long findBig(File dir, String tab) {
        File[] dirContents = dir.listFiles();
        System.out.println(tab+"**:"+dir.getPath());
        long sum = 0;
        for(File f : dirContents){
            if (f.isDirectory()) {
                long subSize = findBig(f,tab+"\t");
                sum += subSize;
                // sum += findBig(f,tab+"\t");
            }
            else {
                
                if (f.length() > THRESHOLD){
                    sum += f.length();
                    System.out.printf("%s%s%8d\n", tab, f.getName(), f.length());
                }
            }
        }        
        return sum;
    }
    
    public static void main(String[] args){
        
        if (args.length > 0){
            THRESHOLD = Long.parseLong(args[0]);
        }
        File dir = FileSelector.selectDirectory();
        if (dir != null){
            long size = findBig(dir,"");
            System.out.printf("total found = %d\n",size);
        }
        System.exit(0);
    }

}
