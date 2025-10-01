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

<img width="689" height="158" alt="Screenshot 2025-10-01 154013" src="https://github.com/user-attachments/assets/d161abcc-b905-4487-884c-f689d1bc4d6a" />

<img width="316" height="174" alt="Screenshot 2025-10-01 154039" src="https://github.com/user-attachments/assets/8152028e-c5aa-4ef6-a972-d13cc6e275b6" />

All tests have passed that's means custom hash function work correct.


### Determinism, one input should not give several results

<img width="559" height="156" alt="Screenshot 2025-10-01 154829" src="https://github.com/user-attachments/assets/8aef1dda-a8dd-4ee7-bcc0-40715c3cfec9" />

<img width="309" height="168" alt="Screenshot 2025-10-01 154905" src="https://github.com/user-attachments/assets/5131fa23-980a-47eb-ab28-78edcf616036" />

All tests have passed that's means custom hash function work correct.


### Hashing performance
We will analyze dependence of input size on hashing speed. To measure hashing speed we have created HashSpeedTest class and Timer class.

| Runs      | 1       | 2       | 4       | 8       | 16       | 32       | 64       | 128      | 256       | 512       |
|-----------|---------|---------|---------|---------|----------|----------|----------|----------|-----------|-----------|
| 1 time    | 586300  | 508600  | 616000  | 716000  | 1119100  | 1406600  | 2416900  | 4888000  | 8941300   | 9610100   |
| 2 time    | 520200  | 476800  | 564700  | 637300  | 1229200  | 1456200  | 2492200  | 4647100  | 8987800   | 9481600   |
| 3 time    | 515700  | 493000  | 561600  | 715900  | 1170500  | 1491900  | 2512800  | 5002300  | 9164600   | 9643000   |
| **Average** | 540733.3 | 492800  | 580766.7 | 689733.3 | 1172933.3 | 1451566.7 | 2473966.7 | 4845800  | 9031233.3 | 9578233.3 |

<img width="481" height="289" alt="Screenshot 2025-10-01 161851" src="https://github.com/user-attachments/assets/872144b3-c5f6-49bc-af98-0f3d1a24227e" />

### Collisions search
We have generated 4 files with 100000 pair of different strings with string length of 10, 100, 500, 1000 symbols. 
<img width="756" height="264" alt="Screenshot 2025-10-01 170520" src="https://github.com/user-attachments/assets/9e365f69-896f-4ae4-96ff-4763e154f0aa" />
<img width="339" height="26" alt="Screenshot 2025-10-01 170540" src="https://github.com/user-attachments/assets/ba67a336-74f5-4d85-85fc-2ab1ab7a65f9" />

Test have found 0 collisions, so we can say collitions percent is close to 0.




