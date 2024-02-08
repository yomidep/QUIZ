
public class Main {
    public static void main(String[] args) {
        // Path to the JSON file
        String filePath = "../src/data/quizes.json";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read JSON data from the file
            StringBuilder jsonData = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonData.append(line);
            }

            // Parse the JSON data using Gson
            Gson gson = new Gson();
            Quiz[] quizList = gson.fromJson(jsonData.toString(), Quiz[].class);

            // Iterate over each quiz
            for (Quiz quiz : quizList) {
                System.out.println("Quiz Name: " + quiz.getName());
                System.out.println("Image URL: " + quiz.getImg());

                // Iterate over each question in the quiz
                for (Question question : quiz.getQuestions()) {
                    System.out.println("Question: " + question.getText());

                    // Iterate over each option in the question
                    for (Option option : question.getOptions()) {
                        System.out.println(option.getLabel() + ": " + option.getText());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
