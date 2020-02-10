public class Validate {
    public Boolean Check(String eq) {
        int sym = 0; //signal for double symbols excl brackets
        int bad = 0;//for fact
        int bra1 = 0;//for ( brackets
        int bra2 = 0;//for ) brackets
        int sop = 0;//for single ops
        int num = 0;//proper decimal
        int num2 = 0;//proper decimal
        int nban = 0;//numbers and random must be seperated
        int rban = 0;
        for (int i = 0 ; i != eq.length() ; i++) {
            char c = eq.charAt(i);
            int n = (int) c; //ascii value of char
            if(n > 47 && n < 58)
            {
                if(bad == 1 || bra2 == 1 || nban == 1)
                    return false;
                sym = 0;    //digits are fine
                sop = 0;
                bra1 = 1;
                num = 0;
                num2 = 0;
                rban = 1;
            }
            else if(n == 114)
            {
                if(bad == 1 || bra2 == 1 || rban == 1 || nban == 1 || num == 1)
                    return false;
                sym = 0;
                sop = 0;
                bra1 = 1;
                num = 0;
                num2 = 0;
                nban = 1;
            }
            else {
                if(num == 1)
                    return false;
                else if(n == 40)
                {
                    if(bra1 == 1)
                        return false;
                    sym = 1;
                    num2 = 0;
                }
                else if(num2 == 1)
                    return false;
                else if(n == 41)
                {
                    bra2 = 1;
                }
                else if(n == 33)
                    bad = 1;
                else if(n == 46)
                {
                    if(sym == 1 || nban == 1)
                        return false;
                    num = 1;
                }
                else if(n == 115 || n == 99 || n == 116 || n == 97 || n == 108)
                {
                    if(bra1 == 1)
                        return false;
                    num2 = 1;
                    sop = 1;
                }
                else if(sym != 1)
                {
                    bra1 = 0;
                    bra2 = 0;
                    bad = 0;
                    sym = 1; //symbol found
                }
                else
                    return false; //two symbols in a row
                    
                nban = 0;
                rban = 0;
            }
        }
        if(sym == 1 || sop == 1 || num == 1)
            return false;
        return Brack(eq);
    }

    public Boolean Brack(String eq) {
        for (int j = 0 ; j != eq.length() ; j++) {
            char c = eq.charAt(j);
            int n = (int) c;
            if (n == 41)
                j = -1;
            if (n == 40)
                j = DeepBrack(eq, j);
            if (j < 0)
                return false;
        }
        return true;
    }

    private int DeepBrack(String eq, int j) {
        int i = j;
        char c = eq.charAt(i);
        int n = (int) c; 
        for (i += 1; i != eq.length() ; i++) {
            c = eq.charAt(i);
            n = (int) c;
            if (n == 41)
                break ;
            if (n == 40)
                i = DeepBrack(eq, i);
            if (i == -1)
                return (-1);
        }
        if (n == 41)
            return (i);
        return (-1);
    }
}