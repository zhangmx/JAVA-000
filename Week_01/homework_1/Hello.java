class Hello {
    byte b_1 = 10;
    short s_1 = 20;
    int i_1 = 30;
    long l_1 = 222222222222L;
    float f_1 = 3.14123124214f;
    double d_1 = 3.4214214124;

    boolean bl = true; 

    char c_1 = '\u0023';

    String str_1 = "\'\n0023\'";

    public void addition(){
        int t = b_1 + s_1;
    }

    public void subtraction(){
        double t = i_1 - d_1;
    }
    public void multiplication(){
        float t = f_1 * l_1;
    }
    public void division(){
        int t = b_1 / s_1;
    }

    public void ifa() {
        if (bl) {
            System.out.println(c_1);
        }
    }

    public void fora() {
        for(int i=0;i<10;i++) {

        }
    }

    public static void main( String [] args) {
        Hello hello = new Hello();

        hello.addition();
        hello.subtraction();
        hello.multiplication();
        hello.division();

        System.out.println(hello.str_1);

    }
}