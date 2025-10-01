# Custom Hash Function
## Pseudo-code
```
function hashString(input, salt):
    input = input + salt
    
    if input is empty:
        input = " "   // single space
    
    // Step 1: Convert characters to integer values
    inputArray = array of character codes from input
    inputList = list of integers from inputArray
    
    // Step 2: Modify each integer using its index
    inputIntegersSum = sum of inputList
    if inputIntegersSum < 0:
        inputIntegersSum = -inputIntegersSum
    additionalInteger = (inputIntegersSum mod 37) + 7
    
    for each index i in inputList:
        inputList[i] = (i * 7 + inputList[i]) mod additionalInteger
    
    // Step 3: Expand inputList until it has at least 64 elements
    while inputList.size < 64:
        for each index i in current inputList:
            inputList.add( inputList[i] + (i mod 2) + 1 )
    
    // Step 4: Shrink inputList until it has exactly 64 elements
    while inputList.size != 64:
        counter = 0
        while inputList.size > 64 and counter < inputList.size:
            integer = ( (inputList[counter] + 7) * (last element of inputList + 7) )
            if integer < 0:
                integer = -integer
            inputList[counter] = integer
            remove last element from inputList
            counter = counter + 1
    
    // Step 5: Mix list using custom mixing function
    inputList = getMixedIntegers(inputList)
    
    // Step 6: Reduce each value to range 0–15
    for each i in inputList:
        inputList[i] = inputList[i] mod 16
    
    // Step 7: Convert list of numbers to hex string
    hexString = ""
    for each integer in inputList:
        hexString = hexString + hex representation of integer
    
    return hexString
```

## Analyze of custom hash function
### Result size should be always same (64 symbols)

![Screenshot 2025-10-01 154013.png](..%2F..%2FOneDrive%2F%C8%E7%EE%E1%F0%E0%E6%E5%ED%E8%FF%2FScreenshots%2FScreenshot%202025-10-01%20154013.png)

![Screenshot 2025-10-01 154039.png](..%2F..%2FOneDrive%2F%C8%E7%EE%E1%F0%E0%E6%E5%ED%E8%FF%2FScreenshots%2FScreenshot%202025-10-01%20154039.png)

All tests have passed that's means custom hash function work correct.
### Determinism, one input should not give several results

![Screenshot 2025-10-01 154829.png](..%2F..%2FOneDrive%2F%C8%E7%EE%E1%F0%E0%E6%E5%ED%E8%FF%2FScreenshots%2FScreenshot%202025-10-01%20154829.png)

![Screenshot 2025-10-01 154905.png](..%2F..%2FOneDrive%2F%C8%E7%EE%E1%F0%E0%E6%E5%ED%E8%FF%2FScreenshots%2FScreenshot%202025-10-01%20154905.png)

All tests have passed that's means custom hash function work correct.

### Hashing performance
We will analyze dependence of input size on hashing speed. To measure hashing speed we have created HashSpeedTest class and Timer class.

| Runs      | 1       | 2       | 4       | 8       | 16       | 32       | 64       | 128      | 256       | 512       |
|-----------|---------|---------|---------|---------|----------|----------|----------|----------|-----------|-----------|
| 1 time    | 586300  | 508600  | 616000  | 716000  | 1119100  | 1406600  | 2416900  | 4888000  | 8941300   | 9610100   |
| 2 time    | 520200  | 476800  | 564700  | 637300  | 1229200  | 1456200  | 2492200  | 4647100  | 8987800   | 9481600   |
| 3 time    | 515700  | 493000  | 561600  | 715900  | 1170500  | 1491900  | 2512800  | 5002300  | 9164600   | 9643000   |
| **Average** | 540733.3 | 492800  | 580766.7 | 689733.3 | 1172933.3 | 1451566.7 | 2473966.7 | 4845800  | 9031233.3 | 9578233.3 |

![Screenshot 2025-10-01 161851.png](..%2F..%2FOneDrive%2F%C8%E7%EE%E1%F0%E0%E6%E5%ED%E8%FF%2FScreenshots%2FScreenshot%202025-10-01%20161851.png)
