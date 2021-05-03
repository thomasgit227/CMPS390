import numpy as np
file = open("names.txt")

class HashTable:
    collisions = 0;

    def __init__(self, len):
        self.len = len;
        self.table = np.full(len, "#---------------#");
        
    def hash(self, input):
        val = ((ord(input[0]) - 97) * 26**2) + ((ord(input[1]) - 97) * 26**1) + ((ord(input[2]) - 97) * 26**0);
        return int(val * (self.len / 17575));

    def placeInTable(self, input):
        hashCode = self.hash(input);
        
        while(True):
            if self.table[hashCode] == "#---------------#":
                self.table[hashCode] = input;
                break;
            else:
                hashCode += 1;
                self.collisions += 1;        

    def printTable(self):
        count = 0;
        for i in self.table:
            print("#: %d | %s" %  (count,i));
            count += 1;
        
        if(self.collisions == 1):
            print("There Has been 1 Collision");
        else:
            print("There Have been %s collisions" % self.collisions);

def main():
    print("Praise Chair");
    myTable = HashTable(100);

    while(True):
        line = file.readline();
        if not line:
            break;
        myTable.placeInTable(line.strip());
    myTable.printTable();

#This Makes it do the Thing - Thomas from the past
if __name__ == "__main__":
    main();