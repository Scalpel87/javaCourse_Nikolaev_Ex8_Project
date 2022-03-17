public class SimpleNote extends Note{
    private String[] head = {"EmptyHead", "EmptyHead", "EmptyHead", "EmptyHead", "EmptyHead"};
    private String[] note = {"EmptyNote", "EmptyNote", "EmptyNote", "EmptyNote", "EmptyNote"};

    @Override
    public void searchNote(String searchWord) {
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            int indexH = head[i].indexOf(searchWord);
            int indexN = note[i].indexOf(searchWord);
            if(!(indexH == - 1) || !(indexN == - 1)) {
                System.out.println("Слово \"" + searchWord + "\" найдено в простой заметке №" + (i + 1) + ":");
                System.out.println(head[i]);
                System.out.println(note[i]);
                flag = true;
            }
        }
        if (!flag) System.out.println("Слово \"" + searchWord + "\" не найдено в простых заметках.");
    }

    @Override
    public String[] getHead() {
        return head;
    }

    @Override
    public void setHead(String[] head) {
        this.head = head;
    }

    @Override
    public String[] getNote() {
        return note;
    }

    @Override
    public void setNote(String[] note) {
        this.note = note;
    }
}
