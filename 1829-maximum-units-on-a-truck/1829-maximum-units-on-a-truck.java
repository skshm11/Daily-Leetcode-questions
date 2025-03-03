class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int units = 0;
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);

        for(int[] boxes: boxTypes){
            int numberOfBoxes = boxes[0];
            int numberOfUnitsPerBox = boxes[1];

            int boxesToAdd = Math.min(numberOfBoxes, truckSize);

            units += boxesToAdd * numberOfUnitsPerBox;

            truckSize -= boxesToAdd;

            if(truckSize == 0) break;
        }

        return units;
    }
}