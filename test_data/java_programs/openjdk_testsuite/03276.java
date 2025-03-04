

class TargetType16 {

    interface SAM1 {
        void m1();
    }

    interface SAM2<X> {
        X m2();
    }

    static void m(SAM1 s1) { }
    static <T> void m(SAM2<T> s2) { }

    public static void main(String[] args) {
        m(() -> { throw new AssertionError(); }); 
    }
}
