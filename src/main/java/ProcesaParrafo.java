import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

public class ProcesaParrafo extends HTMLEditorKit.ParserCallback {

    private  int contador;
    private boolean inParagraph;

    public ProcesaParrafo(){
        contador=0;
        inParagraph=false;
    }

    @Override
    public void handleText(char[] data, int pos) {
        int wordCount=0;
        String delimiters = "\\s+|,\\s*|\\.\\s*|\\;\\s*|\\:\\s*|\\!\\s*|\\¡\\s*|\\¿\\s*|\\?\\s*|\\-\\s*"
                + "|\\[\\s*|\\]\\s*|\\(\\s*|\\)\\s*|\\\"\\s*|\\_\\s*|\\%\\s*|\\+\\s*|\\/\\s*|\\#\\s*|\\$\\s*";
        if( inParagraph ) {
            String texto = new String(data);
            //System.out.println(texto);
            String words[] = texto.split(delimiters);
            wordCount += words.length;
            System.out.printf("Parrafo %d tiene %d palabras",(contador+1),wordCount);
            System.out.println("");

        }
    }

    @Override
    public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
        if(t==HTML.Tag.P){
            inParagraph=true;
        }
    }

    @Override
    public void handleEndTag(HTML.Tag t, int pos) {
        if(t== HTML.Tag.P){
            inParagraph=false;
            contador++;
        }
        if (t==HTML.Tag.BODY){
            System.out.printf("Total de Parrafos en el documento: %d%n", contador);

        }
    }






}
