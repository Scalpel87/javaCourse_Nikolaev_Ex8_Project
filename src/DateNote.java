import java.util.Date;

public class DateNote extends Note{
    private String[] head = {"EmptyHead " + new Date(), "EmptyHead " + new Date(), "EmptyHead " + new Date(), "EmptyHead " + new Date(), "EmptyHead " + new Date()};
    private String[] note = {"EmptyNote", "EmptyNote", "EmptyNote", "EmptyNote", "EmptyNote"};

    @Override
    public void setHead(String[] head) {
        Date date = new Date();
        for (int i = 0; i < 5; i++) {
            if (!this.head[i].equals(head[i])) this.head[i] = head[i] + " Дата: " + date;
        }
    }

    @Override
    public void setNote(String[] note) {
        this.note = note;
    }

    @Override
    public String[] getHead() {
        return head;
    }

    @Override
    public String[] getNote() {
        return note;
    }

    @Override
    public void searchNote(String searchWord) {
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            int indexH = head[i].indexOf(searchWord);
            int indexN = note[i].indexOf(searchWord);
            if(!(indexH == - 1) || !(indexN == - 1)) {
                System.out.println("Слово \"" + searchWord + "\" найдено в заметке с датой №" + (i + 1) + ":");
                System.out.println(head[i]);
                System.out.println(note[i]);
                flag = true;
            }
        }
        if (!flag) System.out.println("Слово \"" + searchWord + "\" не найдено в заметках с датой.");
    }
}
