public class Question {
    public String text;
    public String category;
    public String[] answers;
    public int ansIndex;

    public Question(String _category, String _text, String[] _answers, int _ansIndex) {
        category = _category;
        text = _text;
        answers = _answers;
        ansIndex = _ansIndex;
    }
}
