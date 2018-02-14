package richie_rich;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static String richieRich(String str, int n, int k) {
        int len = str.length();
        int mid = len / 2;
        boolean possible = true;
        HashSet<Integer> set = new HashSet<Integer>();
        char[] s = new char[len];
        s = str.toCharArray();
        for (int i = 0; i < mid; i++) {
            if (s[i] != s[len - i - 1]) {
                set.add(i);
                if (k == 0) {
                    possible = false;
                    break;
                }
                if (s[i] > s[len - i - 1]) {
                    s[len - i - 1] = s[i];
                } else {
                    s[i] = s[len - i - 1];
                }
                k--;
            }
        }

        int b = 0, e = len - 1;
        while (k >= 1 && b < mid) {
            for (; s[b] == '9' && b < mid; b++, e--)
                ;
            if (k > 1) {
                if (b == mid)
                    break;
                k -= 2;
                if (set.contains(b))
                    k++;
                s[b] = '9';
                s[e] = '9';
            } else {
                if (b != mid && set.contains(b)) {
                    s[b] = '9';
                    s[e] = '9';
                    k--;
                }
            }
            b++;
            e--;
        }

        if (k > 0 && len % 2 == 1)
            s[mid] = '9';

        String ret = new String(s);
        if (!possible) {
            ret = "-1";
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        String result = richieRich(s, n, k);
        System.out.println(result);
        in.close();
    }
}
