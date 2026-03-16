public class GoldenVideoStoreApp {
    public static void main(String[] args) {
        Video[] videos = new Video[2];
        videos[0] = new Movie("Inception", "Sci-Fi");
        videos[1] = new Series("Stranger Things", "Horror");

        // Looping through and calling play() on each
        for (Video v : videos) {
            v.play();
        }

        // Using the overloaded play() method
        ((Movie) videos[0]).play("HD");

        // Renting a video
        System.out.println("Renting " + videos[0].getTitle() + "...");
        videos[0].rentVideo();
        System.out.println("Available: " + videos[0].isAvailable());

        // Returning a video
        System.out.println("Returning " + videos[0].getTitle() + "...");
        videos[0].returnVideo();
        System.out.println("Available: " + videos[0].isAvailable());

        // Print a list of available videos
        System.out.print("Available Videos: ");
        for (Video v : videos) {
            if (v.isAvailable()) {
                System.out.print(v.getTitle() + " ");
            }
        }
        System.out.println();
    }
}