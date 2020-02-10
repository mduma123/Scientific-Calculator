public class Rpn {
    public String preCalc(String eq) {
        StringBuilder Uit = new StringBuilder();
        StringBuilder ops = new StringBuilder();
        int end = 0;

        for (int i = 0 ; i != eq.length() ; i++) {
            char c = eq.charAt(i);
            int n = (int) c; //ascii value of char
            if((n > 47 && n < 58) || n == 46 || n == 114)
            {
                if(end == 1)
                    Uit.append(" ");
                Uit.append(c);
                end = 0;
            }
            else if(n == 40)//(
                ops.append(c);
            else if(n == 41)//)
            {
                end = 1;
                char k = ops.charAt(ops.length() - 1);
                int r = (int) k;
                while(r != 40)
                {
                    Uit.append(" ");
                    Uit.append(k);
                    ops.deleteCharAt(ops.length() - 1);
                    k = ops.charAt(ops.length() - 1);
                    r = (int) k;
                }
                ops.deleteCharAt(ops.length() - 1);
            }
            else if(n == 115 || n == 99 || n == 116 || n == 97 || n == 108)//trig functions or absolute value or log
            {
                ops.append(c);
            }
            else if(n == 33)
            {
                end = 1;
                if(ops.length() != 0)
                {
                    char k = ops.charAt(ops.length() - 1);
                    int r = (int) k;
                    while(r == 115 || r == 99 || r == 116 || r == 97 || r == 108)
                    {
                        Uit.append(" ");
                        Uit.append(k);
                        ops.deleteCharAt(ops.length() - 1);
                        if(ops.length() == 0)
                            break ;
                        k = ops.charAt(ops.length() - 1);
                        r = (int) k;
                    }
                }
                ops.append(c);
            }
            else if(n == 94)//power or root (pending)
            {
                end = 1;
                if(ops.length() != 0)
                {
                    char k = ops.charAt(ops.length() - 1);
                    int r = (int) k;
                    while(r == 115 || r == 99 || r == 116 || r == 97 || r == 108 || r == 33)
                    {
                        Uit.append(" ");
                        Uit.append(k);
                        ops.deleteCharAt(ops.length() - 1);
                        if(ops.length() == 0)
                            break ;
                        k = ops.charAt(ops.length() - 1);
                        r = (int) k;
                    }
                }
                ops.append(c);
            }
            else if(n == 42 || n == 47 || n == 37)//division or multplication or modulus
            {
                end = 1;
                if(ops.length() != 0)
                {
                    char k = ops.charAt(ops.length() - 1);
                    int r = (int) k;
                    while(r == 94 || r == 42 || r == 47 || r == 37 || r == 115 || r == 99 || r == 116 || r == 97 || r == 108 || r == 33)
                    {
                        Uit.append(" ");
                        Uit.append(k);
                        ops.deleteCharAt(ops.length() - 1);
                        if(ops.length() == 0)
                            break ;
                        k = ops.charAt(ops.length() - 1);
                        r = (int) k;
                    }
                }
                ops.append(c);
            }
            else if(n == 43 || n == 45)//addition or subtraction
            {
                end = 1;
                if(ops.length() != 0)
                {
                    char k = ops.charAt(ops.length() - 1);
                    int r = (int) k;
                    while(r == 42 || r == 47 || r == 94 || r == 43 || r == 45 || r == 37 || r == 115 || r == 99 || r == 116 || r == 97 || r == 108 || r == 33)
                    {
                        Uit.append(" ");
                        Uit.append(k);
                        ops.deleteCharAt(ops.length() - 1);
                        if(ops.length() == 0)
                            break ;
                        k = ops.charAt(ops.length() - 1);
                        r = (int) k;
                    }
                }
                ops.append(c);
            }
        }
        while(ops.length() != 0)
        {
            char k = ops.charAt(ops.length() - 1);
            Uit.append(" ");
            Uit.append(k);
            ops.deleteCharAt(ops.length() - 1);
        }
        return Uit.toString();
    }
}