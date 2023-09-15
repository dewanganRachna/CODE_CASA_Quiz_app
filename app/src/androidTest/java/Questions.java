public class Questions {

    public String question[]={"Which is a Programming Language?",
            "In COMAL language program, after name of procedure parameters must be in?",
            "Programming language COBOL works best for use in?"};
    public String choices[][]={{"HTML", "CSS", "Vala", "PHP"},
            {"Punction Marks", "Back-Slash", "Brackets", "Semi Colon"},
            {"Siemens Applications", "Student Applications", "Social Applications", "Commercial Applications"}};
    public String correctAnswer[]={ "PHP",
            "Brackets",
            "Commercial Applications"};

    public String getQuestion(int a){
        String questions=question[a];
        return questions;
    }
    public String getChoice1(int a){
        String choice=choices[a][0];
        return  choice;
    }
    public String getChoice2(int a){
        String choice=choices[a][1];
        return  choice;
    }public String getChoice3(int a){
        String choice=choices[a][2];
        return  choice;
    }
    public String getChoice4(int a){
        String choice=choices[a][3];
        return  choice;
    }
    public String getCorrectAnswer(int a){
        String correctAns=correctAnswer[a];
        return correctAns;
    }

}
