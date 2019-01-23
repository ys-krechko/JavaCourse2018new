package task30_10;

import java.io.PrintWriter;

public class ProcessingExceptions {
    public void process(PrintWriter out, String name, String number, String email) throws MissingNameException, MissingEmailAndPhoneNumberException {
        if (name == "") {
            throw new MissingNameException();
        } else if (number == "" & email == "") {
            throw new MissingEmailAndPhoneNumberException();
        } else {
            out.println("<html><head><title>Data Servlet</title></head>");
            out.println("<body><h1>This is your data.</h1>");
            out.println("User Name: " + name + "<br>User's Phone Name: " + number + "<br>User's E-mail Address: " + email + "");
            out.println("</body></html>");
        }
    }
}
