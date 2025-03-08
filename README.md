# Stock Market Transactions and FIFO Capital Gains

## Introduction
Investing in the stock market involves buying and selling shares of companies. When selling shares, the capital gain (or loss) is calculated as the difference between the selling price and the original purchase price of the shares. This is straightforward for individual shares, but when multiple shares are bought over time, determining which shares were sold follows a specific accounting principle known as the **FIFO (First-In, First-Out) protocol**.

## FIFO Protocol Explained
The FIFO protocol states that the shares sold are those that have been held the longest. This means when a sale occurs, shares are deducted from the earliest purchase batches first. 

### Example Calculation
Consider the following transactions:

1. **BUY 100 20** → Purchase 100 shares at R20 each.
2. **BUY 20 24** → Purchase 20 shares at R24 each.
3. **BUY 200 36** → Purchase 200 shares at R36 each.
4. **SELL 150 30** → Sell 150 shares at R30 each.

Applying FIFO:
- The first **100 shares** sold were bought at **R20**, yielding a gain of **(30 - 20) * 100 = R1000**.
- The next **20 shares** sold were bought at **R24**, yielding a gain of **(30 - 24) * 20 = R120**.
- The last **30 shares** sold were bought at **R36**, resulting in a loss of **(30 - 36) * 30 = -R180**.

### Total Capital Gain
Summing the individual gains:
```
1000 + 120 - 180 = R940
```
Thus, the total capital gain is **R940**.

## Implementation Details
To implement this, we need:
1. A data structure to store shares in FIFO order (e.g., a queue).
2. Functions to process **BUY X Y** transactions (adding shares to the queue).
3. Functions to process **SELL X Y** transactions (removing shares from the queue based on FIFO and calculating capital gains).
4. A method to print the final capital gain/loss.

### Expected Output
Given the test case:
```
Transaction: BUY 100 20
Transaction: BUY 20 24
Transaction: BUY 200 36
Transaction: SELL 150 30
Capital Gain/Loss: R940
```
The output of the program should match the expected capital gain/loss calculated above.

## Conclusion
This practical exercise demonstrates how FIFO is used to track stock market transactions efficiently. Implementing this in a program will require using data structures such as queues to manage transactions in the correct order while ensuring capital gain/loss calculations adhere to the FIFO principle.
