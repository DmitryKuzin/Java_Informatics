import model.SortTimer;
import model.file.FileEditor;
import model.sort.BubbleSort;
import model.sort.MergeSort;
import model.sort.QuickSort;
import model.sort.Sort;
import view.ConsoleView;
import java.io.FileNotFoundException;
import java.util.Random;


public class Controller {
    public void run(ConsoleView cv){
        SortTimer timer=new SortTimer();
        boolean isEnd=false;
        int[] arr=null;
        Sort bubble=new BubbleSort();
        Sort merge=new MergeSort();
        Sort quick=new QuickSort();
        cv.showLegend();
        while(!isEnd){
            switch (cv.askWhatToDO()){
                case "-exit": isEnd=true;
                    break;
                case "-add":
                    cv.showMessage("(-console/-file)");
                    String str=cv.askWhatToDO();
                    if(str.equals("-console")){
                        arr=cv.askForArray();
                    }else if(str.equals("-file")){
                        cv.showMessage("insert name of file");
                        try {
                            arr= FileEditor.read(cv.askWhatToDO());
                        } catch (FileNotFoundException e) {
                            cv.showMessage("Can't find it");
                        }

                    }else{
                        cv.showMessage("Can't understand you");
                    }
                    break;
                case "-sort":
                    cv.showMessage("(-Bubble/-Merge/-Quick)");
                    String str1=cv.askWhatToDO();
                    if(str1.equals("-Bubble")){
                        timer.sortAndGetTime(bubble,arr);
                        cv.showArray(arr, "BubbleSort", timer.getHistory().get(timer.getHistory().firstKey()));
                        timer.cleanHistory();
                    }else if(str1.equals("-Merge")){
                        timer.sortAndGetTime(merge,arr);
                        cv.showArray(arr,"MergeSort",timer.getHistory().get(timer.getHistory().firstKey()));
                        timer.cleanHistory();
                    }else if(str1.equals("-Quick")){
                        timer.sortAndGetTime(quick,arr);
                        cv.showArray(arr,"QuickSort",timer.getHistory().get(timer.getHistory().firstKey()));
                        timer.cleanHistory();
                    }else{
                        cv.showMessage("Can't understand you");
                    }
                    break;
                case "-save":
                    cv.showMessage("create name of file");
                    String name=cv.askWhatToDO();
                    FileEditor.write(name,arr);
                    break;
                case "-legend":
                    cv.showLegend();
                    break;
                case "-show":
                    if((arr==null)||(arr.length==0)){
                        cv.showMessage("array is empty now");
                    }else{
                        cv.showArray(arr);
                    }
                    break;
                case "-generate":
                    cv.showMessage("name of items=");
                    arr=new int[new Integer(cv.askWhatToDO())];
                    Random r=new Random();
                    for (int i = 0; i < arr.length; i++) {
                        arr[i]= r.nextInt();
                    }
                    cv.showArray(arr);
                case "-giveMeMore":
                    cv.showFullArray(arr);
                    break;
                default:cv.showMessage("Can't understand you");
                    break;
            }
        }
    }
}
