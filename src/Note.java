public abstract class Note{

    private String[] head = {"EmptyHead", "EmptyHead", "EmptyHead", "EmptyHead", "EmptyHead"};
    private String[] note = {"EmptyNote", "EmptyNote", "EmptyNote", "EmptyNote", "EmptyNote"};

    public String[] getHead() { return head; }
    public String[] getNote() { return note; }

    public void setHead(String[] head) {
        this.head = head;
    }

    public void setNote(String[] note) {
        this.note = note;
    }

    public void searchNote(String searchWord) {
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            int indexH = head[i].indexOf(searchWord);
            int indexN = note[i].indexOf(searchWord);
            if(!(indexH == - 1) || !(indexN == - 1)) {
                System.out.println("Слово \"" + searchWord + "\" найдено в заметке №" + (i + 1) + ":");
                System.out.println(head[i]);
                System.out.println(note[i]);
                flag = true;
            }
        }
           if (!flag) System.out.println("Слово \"" + searchWord + "\" не найдено в заметках.");
    }
}