
import java.util.HashMap


object Arrays {

    fun removeEven(arr: IntArray): IntArray {
        var oddElements = 0

        //Find number of odd elements in arr
        for (i in arr.indices) {
            if (arr[i] % 2 != 0) oddElements++
        }

        //Create result array with size equal to the number of odd elements in arr
        val result = IntArray(oddElements)
        var resultIndex = 0

        //Put odd values from arr to the resulted array
        for (i in arr.indices) {
            if (arr[i] % 2 != 0) result[resultIndex++] = arr[i]
        } //end of for loop
        return result
    } //end of removeEven

    fun mergeArrays(arr1: IntArray, arr2: IntArray): IntArray? {
        val s1 = arr1.size
        val s2 = arr2.size
        val arr3 = IntArray(s1 + s2)
        var i = 0
        var j = 0
        var k = 0

        // Traverse both array
        while (i < s1 && j < s2) {
            // Check if current element of first
            // array is smaller than current element
            // of second array. If yes, store first
            // array element and increment first array
            // index. Otherwise do same with second array
            if (arr1[i] < arr2[j]) arr3[k++] = arr1[i++] else arr3[k++] = arr2[j++]
        }

        // Store remaining elements of first array
        while (i < s1) arr3[k++] = arr1[i++]

        // Store remaining elements of second array
        while (j < s2) arr3[k++] = arr2[j++]
        return arr3
    }

    //Helper Function to sort given Array (Quick Sort)
    fun partition(arr: IntArray, low: Int, high: Int): Int {
        val pivot = arr[high]
        var i = low - 1 // index of smaller element
        for (j in low until high) {
            // If current element is <= to pivot
            if (arr[j] <= pivot) {
                i++

                // swap arr[i] and arr[j]
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        val temp = arr[i + 1]
        arr[i + 1] = arr[high]
        arr[high] = temp
        return i + 1
    }

    fun sort(arr: IntArray?, low: Int, high: Int) {
        if (low < high) {
            val pi = partition(arr!!, low, high)
            sort(arr, low, pi - 1)
            sort(arr, pi + 1, high)
        }
    }

    //Return 2 elements of arr that sum to the given value
    fun findSum(arr: IntArray, n: Int): IntArray? {
        //Helper sort function that uses the Quicksort Algorithm
        sort(arr, 0, arr.size - 1) //Sort the array in Ascending Order
        var pointer1 = 0 //Pointer 1 -> At Start
        var pointer2 = arr.size - 1 //Pointer 2 -> At End
        val result = IntArray(2)
        var sum = 0
        while (pointer1 != pointer2) {
            sum = arr[pointer1] + arr[pointer2] //Calulate Sum of Pointer 1 and 2
            if (sum < n) pointer1++ //if sum is less than given value => Move Pointer 1 to Right
            else if (sum > n) pointer2-- else {
                result[0] = arr[pointer1]
                result[1] = arr[pointer2]
                return result // containing 2 number
            }
        }
        return arr
    }

    fun findProduct(arr: IntArray): IntArray {
        val n = arr.size
        var temp = 1

        // Allocation of result array
        val result = IntArray(n)

        // Product of elements on left side excluding arr[i]
        var i = 0
        while (i < n) {
            result[i] = temp
            temp *= arr[i]
            i++
        }

        // Initializing temp to 1 for product on right side
        temp = 1

        // Product of elements on right side excluding arr[i] */
        i = n - 1
        while (i >= 0) {
            result[i] *= temp
            temp *= arr[i]
            i--
        }
        return result
    }

    fun findFirstUnique(arr: IntArray): Int {
        var result = 0
        // write your code here
        val map = HashMap<Int, Int>()
        for (i in arr) {
            map[i] = map.getOrDefault(i, 0) + 1
        }
        for (i in arr) {
            if (map[i] == 1) {
                result = i
                return result
            }
        }
        return -1
    }

    fun findSecondMaximum(arr: IntArray): Int {
        var max = Int.MIN_VALUE
        var secondMax = Int.MIN_VALUE

        // Keep track of Maximum value, whenever the value at an array index is greater
        // than current Maximum value then make that max value 2nd max value and
        // make that index value maximum value
        for (i in arr.indices) {
            if (arr[i] > max) {
                secondMax = max
                max = arr[i]
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i]
            }
        } //end of for-loop
        return secondMax
    } //end of findSecondMaximum

    fun rotateArray(arr: IntArray) {
        // Write - Your - Code
        val len = arr.size - 1
        val lastElement = arr[len]
        for (i in len downTo 1) {
            arr[i] = arr[i - 1]
        }
        arr[0] = lastElement
    }

    fun reArrange(arr: IntArray) {
        //Write - Your - Code
        var count = 0
        val newArray = IntArray(arr.size)
        for (i in arr.indices) {
            if (arr[i] < 0) {
                newArray[count++] = arr[i]
            }
        }
        for (i in arr.indices) {
            if (arr[i] > 0) {
                newArray[count++] = arr[i]
            }
        }
        for (j in newArray.indices) {
            arr[j] = newArray[j]
        }
    }

    //Re-Arrange Positive and Negative Values of Given Array
    fun reArrange2(arr: IntArray) {
        var j = 0
        for (i in arr.indices) {
            if (arr[i] < 0) {   // if negative number found
                if (i != j) {
                    val temp = arr[i]
                    arr[i] = arr[j] // swapping with leftmost positive
                    arr[j] = temp
                }
                j++
            }
        }
    } //end of reArrange()

    fun maxMin(arr: IntArray) {
        // Write - Your - Code
        var start = 0
        var end = arr.size - 1
        val newArray = IntArray(arr.size)
        var i = 0
        var j = 1
        while (start != end) {
            newArray[i] = arr[end]
            newArray[j] = arr[start]
            start++
            end--
            j += 2
            i += 2
        }
        if (start == end) {
            newArray[newArray.size - 1] = arr[start]
        }
        for (k in arr.indices) {
            arr[k] = newArray[k]
        }
    }

    fun maxMin2(arr: IntArray) {
        //Create a result array to hold re-arranged version of given arr
        val result = IntArray(arr.size)
        var pointerSmall = 0 //PointerSmall => Start of arr
        var pointerLarge = arr.size - 1 //PointerLarge => End of arr

        //Flag which will help in switching between two pointers
        var switchPointer = true
        for (i in arr.indices) {
            if (switchPointer) result[i] = arr[pointerLarge--] // copy large values
            else result[i] = arr[pointerSmall++] // copy small values
            switchPointer = !switchPointer // switching between samll and large
        }
        for (j in arr.indices) {
            arr[j] = result[j] // copying to original array
        }
    }

    fun maxMin3(arr: IntArray) {
        var maxIdx = arr.size - 1
        var minIdx = 0
        val maxElem = arr[maxIdx] + 1 // store any element that is greater than the maximum element in the array
        for (i in arr.indices) {
            // at even indices we will store maximum elements
            if (i % 2 == 0) {
                arr[i] += arr[maxIdx] % maxElem * maxElem
                maxIdx -= 1
            } else { // at odd indices we will store minimum elements
                arr[i] += arr[minIdx] % maxElem * maxElem
                minIdx += 1
            }
        }
        // dividing with maxElem to get original values.
        for (i in arr.indices) {
            arr[i] = arr[i] / maxElem
        }
    }

    fun findMaxSumSubArray(arr: IntArray): Int {
        if (arr.isEmpty()) {
            return 0
        }
        var currMax = arr[0]
        var globalMax = arr[0]
        val len = arr.size
        for (i in 1 until len) {
            if (currMax < 0) {
                currMax = arr[i]
            } else {
                currMax += arr[i]
            }
            if (globalMax < currMax) {
                globalMax = currMax
            }
        }
        return globalMax
    }

}
