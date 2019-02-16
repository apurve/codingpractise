package leave.nucleus.toolbox;

import java.util.Objects;

public class MaximumPairwiseProduct {

    static long getMaxPairwiseProduct(long[] numbers) {
        MaximumPair maximumPair = findMaximumPair(numbers);
        return (maximumPair.getMaximumNumber() * maximumPair.getSecondMaximumNumber());
    }

    static MaximumNumberAndIndex findMaximumNumber(long[] numbers) {
        long maximumNumber = 0;
        long maximumIndex = 0;
        for(int index = 0; index < numbers.length; index++) {
            if(maximumNumber < numbers[index]) {
                maximumNumber = numbers[index];
                maximumIndex = index;
            }
        }
        return new MaximumNumberAndIndex(maximumNumber, maximumIndex);
    }

    static long findSecondMaximumNumber(long[] numbers, long indexOfMaximum) {
        long secondMaximumNumber = 0;
        for(int index = 0; index < numbers.length; index++) {
            if(index != indexOfMaximum && numbers[index] > secondMaximumNumber) {
                secondMaximumNumber = numbers[index];
            }
        }
        return secondMaximumNumber;
    }

    static MaximumPair findMaximumPair(long[] numbers) {
        MaximumNumberAndIndex maximumNumberAndIndex = findMaximumNumber(numbers);
        return new MaximumPair(maximumNumberAndIndex.getMaximumNumber(), findSecondMaximumNumber(numbers, maximumNumberAndIndex.getIndexOfMaximumNumber()));
    }

    public static class MaximumNumberAndIndex {

        private long maximumNumber;

        private long indexOfMaximumNumber;

        public MaximumNumberAndIndex(long maximumNumber, long indexOfMaximumNumber) {
            this.maximumNumber = maximumNumber;
            this.indexOfMaximumNumber = indexOfMaximumNumber;
        }

        public long getMaximumNumber() {
            return maximumNumber;
        }

        public void setMaximumNumber(long maximumNumber) {
            this.maximumNumber = maximumNumber;
        }

        public long getIndexOfMaximumNumber() {
            return indexOfMaximumNumber;
        }

        public void setIndexOfMaximumNumber(long indexOfMaximumNumber) {
            this.indexOfMaximumNumber = indexOfMaximumNumber;
        }

    }

    public static class MaximumPair {

        private long maximumNumber;

        private long secondMaximumNumber;

        public MaximumPair(long maximumNumber, long secondMaximumNumber) {
            this.maximumNumber = maximumNumber;
            this.secondMaximumNumber = secondMaximumNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MaximumPair)) return false;
            MaximumPair that = (MaximumPair) o;
            return maximumNumber == that.maximumNumber &&
                    secondMaximumNumber == that.secondMaximumNumber;
        }

        @Override
        public int hashCode() {
            return Objects.hash(maximumNumber, secondMaximumNumber);
        }

        public long getMaximumNumber() {
            return maximumNumber;
        }

        public void setMaximumNumber(long maximumNumber) {
            this.maximumNumber = maximumNumber;
        }

        public long getSecondMaximumNumber() {
            return secondMaximumNumber;
        }

        public void setSecondMaximumNumber(long secondMaximumNumber) {
            this.secondMaximumNumber = secondMaximumNumber;
        }

    }

}