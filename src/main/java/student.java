public class student {
    private int number;
    private String name;
    private int ms;
    private int es;
    public student(String[] data){
        this.number = Integer.parseInt(data[0]);
        this.name = data[1];
        this.ms = Integer.parseInt(data[2]);
        this.es = Integer.parseInt(data[3]);
    }
    public String getName(){
        return name;
    }
    public int getNumber(){
        return number;
    }
    public int getMs(){
        return ms;
    }
    public int getEs(){
        return es;
    }

    public String toString(){
        return "{Student ID:" + number + ",name:" + name + ",math score:" + ms + ",english score:" + es +"}";
    }

}
