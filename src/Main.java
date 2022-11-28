import org.omg.PortableInterceptor.INACTIVE;

import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first phrase:");
        String str1 = input.nextLine() + " ";
        str1 = checkstr(str1);
        System.out.println("Enter secend phrase:");
        String str2 = input.nextLine() + " ";
        str2 = checkstr(str2);
        String sum = sum(str1, str2);
        sum = checkstr(sum);
        System.out.println(sum);

    }


    public static String sum(String str1, String str2) {
        String sum = "";
        String s2 = "";
        int f = 0;
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) != ' ') {
                s2 = s2 + str2.charAt(i);
            } else {
                String num1 = "";
                String num2 = "";
                int j = 0;
                int coefficient, max;
                for (; j < s2.length() && s2.charAt(j) != 'x'; j++) {
                    num1 = num1 + s2.charAt(j);
                }
                if (j - 1 != -1 && s2.charAt(j - 1) == '-') {
                    coefficient = -1;
                } else if (j - 1 == -1 || s2.charAt(j - 1) == '+') {
                    coefficient = 1;
                } else {
                    coefficient = Integer.valueOf(num1);
                }
                if (!s2.contains("x")) {
                    max = 0;
                } else if (j + 1 >= s2.length()) {
                    max = 1;
                } else {
                    for (; j < s2.length(); j++) {
                        if (s2.charAt(j)!='^'&&s2.charAt(j)!='x'){
                        num2 = num2 + s2.charAt(j);
                        }
                    }
                    if (!num2.equals("")) {
                        max = Integer.valueOf(num2);
                    } else {
                        max = 1;
                    }
                }
                String newstr = Halfsum(str1, coefficient, max);
                if (f == 0) {
                    sum = sum + newstr;
                } else {
                    if (newstr.charAt(0) != '-') {
                        sum = sum + "+" + newstr;
                    } else {
                        sum = sum  + newstr;
                    }
                }
                s2 = "";
                f++;
            }

        }
        return sum;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public static String Halfsum(String str1, int coefficient, int max) {
        int f = 0;
        String sum = "";
        String s1 = "";
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != ' ') {
                s1 = s1 + str1.charAt(i);
            } else {
                String num1 = "";
                String num2 = "";
                int coefficient1, max1;
                int j = 0;
                for (; j < s1.length() && s1.charAt(j) != 'x'; j++) {
                    num1 = num1 + s1.charAt(j);
                }
                if (s1.charAt(j - 1) == '-') {
                    coefficient1 = -1;
                } else if (j - 1 == -1 || s1.charAt(j - 1) == '+') {
                    coefficient1 = 1;
                } else {
                    coefficient1 = Integer.valueOf(num1);
                }
                if (!s1.contains("x")) {
                    max1 = 0;
                } else if (j + 1 >= s1.length()) {
                    max1 = 1;
                } else {
                    for (; j < s1.length(); j++) {
                        if (s1.charAt(j)!='^'&&s1.charAt(j)!='x'){
                            num2 = num2 + s1.charAt(j);
                        }
                    }
                    if (!num2.equals("")) {
                        max1 = Integer.valueOf(num2);
                    } else {
                        max1 = 1;
                    }
                }
                int newcoefficient = coefficient * coefficient1;
                int newmax = max + max1;
                if (f == 0) {
                    if (newcoefficient == 1 && newmax == 1) {
                        sum = sum + "x" + " ";
                    } else if (newcoefficient == -1 && newmax == 0) {
                        sum = sum + newcoefficient + " ";
                    } else if (newcoefficient == 1 && newmax == 0) {
                        sum = sum + newcoefficient + " ";
                    } else if (newcoefficient == -1 && newmax == 1) {
                        sum = sum + "-x" + " ";
                    } else if (newcoefficient == -1 && newmax > 1) {
                        sum = sum + "-x^" + newmax + " ";
                    } else if (newcoefficient == 1 && newmax > 1) {
                        sum = sum + "x^" + newmax + " ";
                    } else if (newcoefficient != 1 && newmax == 1) {
                        sum = sum + newcoefficient + "x" + " ";
                    } else if (newcoefficient != 1 && newcoefficient > 0 && newmax == 0) {
                        sum = sum + newcoefficient + " ";
                    } else if (newcoefficient != 1 && newcoefficient < 0 && newmax == 0) {
                        sum = sum + newcoefficient + " ";
                    } else if (newcoefficient != 1 && newcoefficient > 0 && newmax != 1) {
                        sum = sum + newcoefficient + "x^" + newmax + " ";
                    } else {
                        sum = sum + newcoefficient + "x^" + newmax + " ";
                    }
                } else {
                    if (newcoefficient == 1 && newmax == 1) {
                        sum = sum + "+x" + " ";
                    } else if (newcoefficient == -1 && newmax == 0) {
                        sum = sum + newcoefficient + " ";
                    } else if (newcoefficient == 1 && newmax == 0) {
                        sum = sum + "+" + newcoefficient + " ";
                    } else if (newcoefficient == -1 && newmax == 1) {
                        sum = sum + "-x" + " ";
                    } else if (newcoefficient == -1 && newmax > 1) {
                        sum = sum + "-x^" + newmax + " ";
                    } else if (newcoefficient == 1 && newmax > 1) {
                        sum = sum + "+x^" + newmax + " ";
                    } else if (newcoefficient != 1&&newcoefficient < 0 && newmax == 1) {
                        sum = sum  + newcoefficient + "x" + " ";
                    } else if (newcoefficient != 1&&newcoefficient > 0 && newmax == 1) {
                        sum = sum + "+" + newcoefficient + "x" + " ";
                    } else if (newcoefficient != 1 && newcoefficient > 0 && newmax == 0) {
                        sum = sum + "+" + newcoefficient + " ";
                    } else if (newcoefficient != 1 && newcoefficient < 0 && newmax == 0) {
                        sum = sum + "+" + newcoefficient + " ";
                    } else if (newcoefficient != 1 && newcoefficient > 0 && newmax != 1) {
                        sum = sum + "+" + newcoefficient + "x^" + newmax + " ";
                    } else {
                        sum = sum + newcoefficient + "x^" + newmax + " ";
                    }
                }
                f++;
                s1 = "";
            }

        }
        return sum;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////
    public static String checkstr(String str) {
        String string = "";
        int max = 0;
        int f, e = 0;
        int l = 0;
        while (max != -1 && !str.equals("")) {
            max = 0;
            for (int i = 0; i < str.length(); i++) {
//                char ch=str.charAt(i);
                if (str.charAt(i) == ' ') {
                    boolean flag = true;
                    int num;

                    String strname = "";
                    int j = i - 1;
//                    char c=str.charAt(j);
                    if (i - 1 != -1 && str.charAt(i - 1) == 'x') {
                        num = 1;
                    } else {
                        int z = j;
                        while (z != -1 && str.charAt(z) != '+' && str.charAt(z) != '-') {
                            if (str.charAt(z) == 'x') {
                                flag = false;
                                break;
                            }
                            z--;
                        }
                        if (flag) {
                            continue;
                        }
                        while (j != -1 && str.charAt(j) != '^') {
                            j--;
                        }
                        j++;
                        while (j != -1 && str.charAt(j) != ' ') {
                            strname = strname + str.charAt(j);
                            j++;
                        }
                        num = Integer.valueOf(strname);
                    }
                    if (max < num) {
                        max = num;
                    }
                }
            }
            int coefficient = 0;
            if (max == 0) {
                str = str + " ";
                int num;
                String strnum = "";
                for (int i = 0; str.length() > i; i++) {
                    if (str.charAt(i) != ' ') {
                        strnum = strnum + str.charAt(i);
                    } else if (strnum.equals("")) {
                        continue;
                    } else {
                        num = Integer.valueOf(strnum);
                        coefficient = coefficient + num;
                        strnum = "";
                    }

                }
                if (coefficient > 0) {
                    string = string + "+" + coefficient + " ";
                    return string;
                } else {
                    string = string + coefficient + " ";
                    return string;
                }
            } else {
                int num;
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == ' ') {
                        int j = i - 1;
                        boolean flag = true;
                        if (str.charAt(j) == 'x') {
                            num = 1;
                            e = j + 1;
                        } else {
                            int z = j;
                            while (z != -1 && str.charAt(z) != '+' && str.charAt(z) != '-') {
                                if (str.charAt(z) == 'x') {
                                    flag = false;
                                    break;
                                }
                                z--;
                            }
                            if (flag) {
                                continue;
                            }
                            String strnum = "";
                            if (str.charAt(j-1) == 'x') {
                                num = 1;
                                e=j;
                            } else {
                                while (j != -1 && str.charAt(j) != '^') {
                                    j--;
                                }
                                j++;
                                while (j != -1 && str.charAt(j) != ' ') {
                                    strnum = strnum + str.charAt(j);
                                    j++;
                                }
                                e = j;
                                j--;
                                num = Integer.valueOf(strnum);
                            }
                        }
                        if (max == num) {
                            String coefficient1 = "";
                            while (j != -1 && str.charAt(j) != ' ') {
                                j--;
                            }
                            if (j == -1) {
                                f = 0;
                            } else {
                                f = j;
                            }
                            j++;
                            if (str.charAt(j) == '-'&&str.charAt(j+1)=='x') {
                                coefficient = coefficient - 1;
                            } else if (str.charAt(j) == '+'&&str.charAt(j+1)=='x') {
                                coefficient = coefficient + 1;

                            } else {
                                while (str.charAt(j) != 'x') {
                                    coefficient1 = coefficient1 + str.charAt(j);
                                    j++;
                                }
                                if (!coefficient1.equals("")) {
                                    int coefficient2 = Integer.valueOf(coefficient1);
                                    coefficient = coefficient + coefficient2;
                                } else {
                                    coefficient = coefficient + 1;
                                }
                            }
                            String newstr = "";
                            int k=0;
                            int d=0;
                            for (; k < f; k++) {
                                d++;
                                newstr = newstr + str.charAt(k);
                            }
                            e++;
                            if (d != 0) {
                                if (e<str.length()&&str.charAt(e) != ' ') {
                                    if (k-1!=-1&&newstr.charAt(k-1) != ' ') {
                                        newstr = newstr + " ";
                                    }
                                }
                            }
                            for (k = e; k < str.length(); k++) {
                                newstr = newstr + str.charAt(k);
                            }
                            str = newstr;
                            i = 0;
                        }
                    }
                }
            }
            if (coefficient != 0) {
                if (l == 0) {
                    if (coefficient == 1 && max == 1) {
                        string = string + "x" + " ";
                    } else if (coefficient == -1 && max == 0) {
                        string = string + coefficient + " ";
                    } else if (coefficient == 1 && max == 0) {
                        string = string + coefficient + " ";
                    } else if (coefficient == -1 && max == 1) {
                        string = string + "-x" + " ";
                    } else if (coefficient == -1 && max > 1) {
                        string = string + "-x^" + max + " ";
                    } else if (coefficient == 1 && max > 1) {
                        string = string + "x^" + max + " ";
                    } else if (coefficient != 1 && max == 1) {
                        string = string + coefficient + "x" + " ";
                    } else if (coefficient != 1 && coefficient > 0 && max == 0) {
                        string = string + coefficient + " ";
                    } else if (coefficient != 1 && coefficient < 0 && max == 0) {
                        string = string + coefficient + " ";
                    } else if (coefficient != 1 && coefficient > 0 && max != 1) {
                        string = string + coefficient + "x^" + max + " ";
                    } else {
                        string = string + coefficient + "x^" + max + " ";
                    }
                } else {
                    if (coefficient == 1 && max == 1) {
                        string = string + "+x" + " ";
                    } else if (coefficient == -1 && max == 0) {
                        string = string + coefficient + " ";
                    } else if (coefficient == 1 && max == 0) {
                        string = string + "+" + coefficient + " ";
                    } else if (coefficient == -1 && max == 1) {
                        string = string + "-x" + " ";
                    } else if (coefficient == -1 && max > 1) {
                        string = string + "-x^" + max + " ";
                    } else if (coefficient == 1 && max > 1) {
                        string = string + "+x^" + max + " ";
                    } else if (coefficient != 1&&coefficient < 0 && max == 1) {
                        string = string  + coefficient + "x" + " ";
                    } else if (coefficient != 1&&coefficient > 0 && max == 1) {
                        string = string + "+" + coefficient + "x" + " ";
                    } else if (coefficient != 1 && coefficient > 0 && max == 0) {
                        string = string + "+" + coefficient + " ";
                    } else if (coefficient != 1 && coefficient < 0 && max == 0) {
                        string = string + "+" + coefficient + " ";
                    } else if (coefficient != 1 && coefficient > 0 && max != 1) {
                        string = string + "+" + coefficient + "x^" + max + " ";
                    } else {
                        string = string + coefficient + "x^" + max + " ";
                    }
                }
                l++;
            }
        }
        return string;
    }
}
