public class Program {
    public static void main(String[] args){
        Integer count = null;
        Action dispute;

        if (args.length != 1 || !args[0].startsWith("--count=")){
            System.err.println("The wrong input!");
            System.exit(-1);
        }
        try {
            count = Integer.parseInt(args[0].substring(8));
        } catch (NumberFormatException e){
            System.err.println("Wrong number!");
            System.exit(-1);
        }

        dispute = new Action(count);
        dispute.play();

        for (int i=0; i < count; i++){
            System.out.println("Human");
        }
    }
}