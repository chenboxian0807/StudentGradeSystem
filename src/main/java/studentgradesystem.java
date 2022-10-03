import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class studentgradesystem {
    FileReader file = new FileReader("grade.txt");
    BufferedReader br = new BufferedReader(file);
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Integer> ID = new ArrayList<>();
    private ArrayList<String> name = new ArrayList<>();
    private ArrayList<Integer> mathscore = new ArrayList<>();
    private ArrayList<Integer> englishscore = new ArrayList<>();
    private ArrayList<student> students = new ArrayList<>();
    private ArrayList<student> copy = new ArrayList<>();

    public studentgradesystem() throws IOException {
        frontpage();
    }

    public void readfile() throws IOException {
        while (true) {
            String s = br.readLine();
            if (s == null) {
                break;
            }
            String[] datas = s.split(",");
            student student = new student(datas);
            students.add(student);
            mathscore.add(Integer.parseInt(datas[2]));
            englishscore.add(Integer.parseInt(datas[3]));
        }
        for (int i = 0; i < students.size(); i++) {
            copy.add(students.get(i));
        }
        file.close();
    }

    public void listall() throws IOException {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

    public void IDsorting() {
        int i, j, key;
        student s_key;
        for (j = 1; j < students.size(); j++) {
            key = students.get(j).getNumber();
            s_key = students.get(j);
            i = j - 1;
            while (i >= 0 && students.get(i).getNumber() > key) {
                students.set(i + 1, students.get(i));
                i = i - 1;
            }
            students.set(i + 1, s_key);
        }
    }

    public void namesorting() {
        int i, j;
        String key;
        student s_key;
        for (j = 1; j < students.size(); j++) {
            key = students.get(j).getName();
            s_key = students.get(j);
            i = j - 1;
            while (i >= 0 && (students.get(i).getName().compareTo(key) > 0)) {
                students.set(i + 1, students.get(i));
                i = i - 1;
            }
            students.set(i + 1, s_key);
        }
    }

    public void mssorting() {
        int i, j, key;
        student s_key;
        for (j = 1; j < students.size(); j++) {
            key = students.get(j).getMs();
            s_key = students.get(j);
            i = j - 1;
            while (i >= 0 && students.get(i).getMs() > key) {
                students.set(i + 1, students.get(i));
                i = i - 1;
            }
            students.set(i + 1, s_key);
        }
    }

    public void essorting() {
        int i, j, key;
        student s_key;
        for (j = 1; j < students.size(); j++) {
            key = students.get(j).getEs();
            s_key = students.get(j);
            i = j - 1;
            while (i >= 0 && students.get(i).getEs() > key) {
                students.set(i + 1, students.get(i));
                i = i - 1;
            }
            students.set(i + 1, s_key);
        }
    }

    public void msscoredistance() {
        int a = 0, b = 0, c = 0, d = 0, e = 0;
        for (int i = 0; i < mathscore.size(); i++) {
            if (mathscore.get(i) >= 0 && mathscore.get(i) <= 59) {
                e++;
            } else if (mathscore.get(i) >= 60 && mathscore.get(i) <= 69) {
                d++;
            } else if (mathscore.get(i) >= 70 && mathscore.get(i) <= 79) {
                c++;
            } else if (mathscore.get(i) >= 80 && mathscore.get(i) <= 89) {
                b++;
            } else
                a++;
        }
        System.out.println("");
        System.out.println("數學 100~90分的有 : " + a + "人");
        System.out.println("數學 89~80分的有 : " + b + "人");
        System.out.println("數學 79~70分的有 : " + c + "人");
        System.out.println("數學 69~60分的有 : " + d + "人");
        System.out.println("數學 59~0分的有 : " + e + "人");
        System.out.println("");
    }

    public void esscoredistance() {
        int a = 0, b = 0, c = 0, d = 0, e = 0;
        for (int i = 0; i < englishscore.size(); i++) {
            if (englishscore.get(i) >= 0 && englishscore.get(i) <= 59) {
                e++;
            } else if (englishscore.get(i) >= 60 && englishscore.get(i) <= 69) {
                d++;
            } else if (englishscore.get(i) >= 70 && englishscore.get(i) <= 79) {
                c++;
            } else if (englishscore.get(i) >= 80 && englishscore.get(i) <= 89) {
                b++;
            } else
                a++;
        }
        System.out.println("");
        System.out.println("英文 100~90分的有 : " + a + "人");
        System.out.println("英文 89~80分的有 : " + b + "人");
        System.out.println("英文 79~70分的有 : " + c + "人");
        System.out.println("英文 69~60分的有 : " + d + "人");
        System.out.println("英文 59~0分的有 : " + e + "人");
        System.out.println("");
    }

    public int sID(ArrayList<student> students, int num) {
        int low = 0, mid = 0, high = 0;
        high = students.size() - 1;
        while (low <= high) {
            mid = (int) ((low + high) / 2);
            if (students.get(mid).getNumber() < num) {
                low = mid + 1;
            } else if (students.get(mid).getNumber() > num) {
                high = mid - 1;
            } else return mid;
        }
        return -1;
    }

    public int sn(ArrayList<student> students, String name) {
        int low = 0, mid = 0, high = 0;
        high = students.size() - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (students.get(mid).getName().compareTo(name) < 0) {
                low = mid + 1;
            } else if (students.get(mid).getName().compareTo(name) > 0) {
                high = mid - 1;
            }
            else return mid;
        }
        return -1;
    }

    public void frontpage() throws IOException {
        int i;
        String commend1 = "grade.txt";
        String commend2 = "BS";
        String commend3 = "freq";
        String commend4 = "Eng";
        String commend5 = "Reset";
        String commend6 = "all";
        String commend7 = "name";
        String commend8 = "ID";
        String commend9 = "Math";
        String commend10 = "Eng";
        String commend11 = "Quit";
        System.out.println("指令 : (1)R grade.txt (2)BS+姓名 (3)BS+ID (4)freQ Math (5)freq Eng (6)Reset");
        System.out.println("      (7)List all (8)List name (9)List ID (10)List Math (11)List Eng (12)Quit");
        System.out.println("請輸入指令: ");
        scanner.useDelimiter("\n");
        String[] iuput = scanner.next().split(" ");
        if (iuput.length == 1){
            if (iuput[0].compareTo(commend5) == 0){
                for ( i = 0 ; i < copy.size() ; i++){
                    students.add(copy.get(i));
                }
                System.out.println("資料重置完畢");
                frontpage();
            }
            else if (iuput[0].compareTo(commend11) == 0){
                System.out.println("----- 結束 -----");
                System.exit(0);
            }
            else System.out.println("請重新輸入");
            frontpage();
        }
        else if (iuput.length == 2){
            if (iuput[1].compareTo(commend1) == 0){
                readfile();
                System.out.println("----- 檔案讀取完成 ------");
                frontpage();
            }
        else if (iuput[0].compareTo(commend2) == 0){
                if (iuput[0].compareTo(iuput[1]) > 1 ){
                    IDsorting();
                    System.out.println(students.get(sID(students,Integer.parseInt(iuput[1]))));
                }
                else if (iuput[0].compareTo(iuput[1]) <= 1){
                    namesorting();
                    System.out.println(students.get(sn(students,iuput[1])));
                }
                frontpage();
        }
            else if (iuput[0].compareTo(commend3) == 0){
                if (iuput[1].compareTo(commend4) == 0){
                    esscoredistance();
                }
                else msscoredistance();
                frontpage();
            }
            else if (iuput[1].compareTo(commend6) == 0){
                listall();
                frontpage();
            }
            else if (iuput[1].compareTo(commend7) == 0){
                namesorting();
                for (i=0;i<students.size();i++){
                    System.out.println(students.get(i));
                }
                frontpage();
            }
            else if (iuput[1].compareTo(commend8) == 0){
                IDsorting();
                for (i=0;i<students.size();i++){
                    System.out.println(students.get(i));
                }
                frontpage();
            }
            else if (iuput[1].compareTo(commend9) == 0){
                mssorting();
                for (i=0;i<students.size();i++){
                    System.out.println(students.get(i));
                }
                frontpage();
            }
            else if (iuput[1].compareTo(commend10) == 0){
                essorting();
                for (i=0;i<students.size();i++){
                    System.out.println(students.get(i));
                }
                frontpage();
            }
        }
    }
}


