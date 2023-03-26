package ui;

import statistic.ItemRank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;

/**
 * The StatisticUi class extends the Ui class and provides
 * methods for displaying various statistical data in a user-friendly manner.
 */
public class StatisticUi extends Ui {

    /**
     * Prints the header for a daily bar chart.
     *
     * @param startDate  The start date of the date range for which the chart is being printed.
     * @param endDate    The end date of the date range for which the chart is being printed.
     * @param totalSales The total sales for the date range.
     */
    public void printDailyBarChartHeader(LocalDateTime startDate, LocalDateTime endDate, double totalSales) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("| " + "-".repeat(131) + " |");
        System.out.printf("| %-131s |\n", "Daily statistic for the date range "
                            + startDate.format(formatter) + " - " + endDate.format(formatter));
        System.out.printf("| Total sales: $%-117.2f |\n", totalSales);
        System.out.println("| " + "-".repeat(131) + " |");
        System.out.printf("| %-12s | %-13s | %-100s |\n", "Date", "Sales($)", "Performance");
    }

    /**
     * Prints a single data and bar in the chart corresponding to the date.
     *
     * @param indexDate The date for which the bar is being printed.
     * @param numOfBars The number of bars to display for the given value.
     * @param value     The value to display.
     */
    public void printDailyBarChart(LocalDateTime indexDate, int numOfBars, double value) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String formattedDate = indexDate.format(formatter);

        System.out.println("| " + "-".repeat(12) + " | " + "-".repeat(13) + " | " + "-".repeat(100) + " |");
        System.out.printf("| %-12s | %-13.2f | %-100s |\n", formattedDate, value, "|".repeat(numOfBars));
    }

    public void printBarChartFooter() {
        System.out.println("| " + "-".repeat(131) + " |");
    }

    /**
     * Prints the header for a monthly bar chart.
     *
     * @param year       The year for which the chart is being printed.
     * @param totalSales The total sales for the year.
     */
    public void printMonthlyChartHeader(int year, double totalSales) {
        System.out.println("| " + "-".repeat(131) + " |");
        System.out.printf("| %-131s |\n", "Monthly statistic for the year " + year);
        System.out.printf("| Total sales: $%-117.2f |\n", totalSales);
        System.out.println("| " + "-".repeat(131) + " |");
        System.out.printf("| %-10s | %-15s | %-100s |\n", "Month", "Sales($)", "Performance");
    }

    /**
     * Prints a single data and bar in the chart corresponding to the month.
     *
     * @param indexDate The date for which the bar is being printed.
     * @param numOfBars The number of bars to display for the given value.
     * @param value     The value to display.
     */
    public void printMonthlyBarChart(LocalDateTime indexDate, int numOfBars, double value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM yyyy");

        String formattedDate = indexDate.format(formatter);

        System.out.println("| " + "-".repeat(10) + " | " + "-".repeat(15) + " | " + "-".repeat(100) + " |");
        System.out.printf("| %-10s | %-15.2f | %-100s |\n", formattedDate, value, "|".repeat(numOfBars));

    }

    /**
     * A method that prints a popularity ranking table based on the quantity sold for each item
     * within a specified date range.
     *
     * @param rank      a PriorityQueue of ItemRank objects, sorted by quantity sold in descending order
     * @param startDate a LocalDateTime object representing the start date of the date range
     * @param endDate   a LocalDateTime object representing the end date of the date range
     */
    public void printPopularityRankingTable(PriorityQueue<ItemRank> rank,
                                            LocalDateTime startDate, LocalDateTime endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("| " + "-".repeat(41) + " |");
        System.out.println("|" + " Rank by quantity sold" + " ".repeat(21) + "|");
        System.out.printf("| %-41s |\n", "Date: " + startDate.format(formatter) + " - " + endDate.format(formatter));
        System.out.println("| " + "-".repeat(41) + " |");
        System.out.printf("| %-5s | %-25s | %-5s |\n", "Rank", "Name", "Count");
        System.out.println("| " + "-".repeat(5) + " | " + "-".repeat(25) + " | " + "-".repeat(5) + " |");

        int index = 1;

        while (!rank.isEmpty()) {
            ItemRank element = rank.poll();
            System.out.printf("| %-5d | %-25s | %-5d |\n", index, element.getName(), (int) element.getValue());
            index++;
        }

        System.out.println("| " + "-".repeat(41) + " |\n");
    }

    /**
     * A method that prints a sales ranking table based on the total sales amount for each item
     * within a specified date range.
     *
     * @param rank      a PriorityQueue of ItemRank objects, sorted by total sales amount in descending order
     * @param startDate a LocalDateTime object representing the start date of the date range
     * @param endDate   a LocalDateTime object representing the end date of the date range
     */
    public void printSalesRankingTable(PriorityQueue<ItemRank> rank, LocalDateTime startDate, LocalDateTime endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("| " + "-".repeat(46) + " |");
        System.out.println("|" + " Rank by sales" + " ".repeat(34) + "|");
        System.out.printf("| %-46s |\n", "Date: " + startDate.format(formatter) + " - " + endDate.format(formatter));
        System.out.println("| " + "-".repeat(46) + " |");
        System.out.printf("| %-5s | %-25s | %-10s |\n", "Rank", "Name", "Sales($)");
        System.out.println("| " + "-".repeat(5) + " | " + "-".repeat(25) + " | " + "-".repeat(10) + " |");

        int index = 1;

        while (!rank.isEmpty()) {
            ItemRank element = rank.poll();
            System.out.printf("| %-5d | %-25s | %-10.2f |\n", index, element.getName(), element.getValue());
            index++;
        }

        System.out.println("| " + "-".repeat(46) + " |\n");
    }

    @Override
    public void printError(Flags.Error error) {
        System.out.print("Error: ");
        switch (error) {
        case DOUBLE_OVERFLOW:
            System.out.println("Double overflow! Please enter a double within the valid range.");
            break;
        case INTEGER_OVERFLOW:
            System.out.println("Integer overflow! Please enter an integer within the valid range.");
            break;
        default:
            // Fallthrough
        }
    }
}