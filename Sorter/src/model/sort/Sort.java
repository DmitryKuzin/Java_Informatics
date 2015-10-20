package model.sort;

public abstract class Sort implements iSort{
    public Sort(){
        nameOfAlgorithm=this.toString();
    }
    private String nameOfAlgorithm;
    public String getNameOfAlgorithm(){
        return nameOfAlgorithm;
    }
    @Override
    public int[] sort(int[] arr){
         return sortAlgorithm(arr);
     }
    abstract int[] sortAlgorithm(int[] array);
}
