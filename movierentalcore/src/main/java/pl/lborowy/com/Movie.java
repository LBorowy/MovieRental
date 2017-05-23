package pl.lborowy.com;

/**
 * Created by RENT on 2017-05-19.
 */
public class Movie implements CsvObject {
    public static final String CSV_SEPARATOR = ",";
    private static int nextId = 0;

    private int id;
    private String title;
    private String genre;
    private String description;

    public Movie(String text) {
        String[] split = text.split(CSV_SEPARATOR);

        this.id = Integer.parseInt(split[0]);
        this.title = split[1];
        this.genre = split[2];
        this.description = split[3];
    }

    public Movie(String title, String genre, String description) {
        this.id = nextId;
        nextId++;
        this.title = title;
        this.genre = genre;
        this.description = description;
    }

    public static void setNextId(int nextId) {
        Movie.nextId = nextId;
    }

    public String toCSVString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(id);
        stringBuilder.append(CSV_SEPARATOR);
        stringBuilder.append(title);
        stringBuilder.append(CSV_SEPARATOR);
        stringBuilder.append(genre);
        stringBuilder.append(CSV_SEPARATOR);
        stringBuilder.append(description);

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
