class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = Integer.toString(n).toCharArray();
        int i = arr.length - 2;
        // 1 find breakpoint
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        // no greater number
        if (i < 0)
            return -1;

        // 2. find just greater element
        int j = arr.length - 1;

        while (arr[j] <= arr[i]) {
            j--;
        }
        //swap
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // step 3 reverse right part
        reverse(arr, i + 1, arr.length - 1);

        long num = Long.parseLong(new String(arr));

        if (num > Integer.MAX_VALUE) {
            return -1;

        }
        return (int) num;
    }

    void reverse(char[] arr, int left, int right) {
        while (left < right) {

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}