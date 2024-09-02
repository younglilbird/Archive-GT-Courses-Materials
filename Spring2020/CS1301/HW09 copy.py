# test1
def pyramid(height, char):
    if(height==1):
        print(char)
    else:
        pyramid(height-1, char)
        print(char+("."*(height-2))+char)

# test 2
def patterns(first):
    if len(first)==2:
        return 0
    if first[0]==first[2]!=first[1]:
        return 1+patterns(first[1:])
    else:
        return patterns(first[1:])

#test 3
def get_max(tup):
    if(len(tup) == 1):
        return tup[0]
    maximum = get_max(tup[1:])
    if(maximum < tup[0]):
        maximum = tup[0]
    return maximum
def get_min(tup):
    if(len(tup) == 1):
        return tup[0]
    minimum = get_min(tup[1:])
    if(minimum > tup[0]):
        minimum = tup[0]
    return minimum
def stats(tup):
    if tup==():
        return []
    if len(tup)==1:
        return [tup[0],tup[0]]
    elif tup[0]<tup[1]:
        return [get_min(tup),get_max(tup)]
    else:
        return [get_min(tup),get_max(tup)]

#test 4    
def fibtionary(num):
    if num==1:
        return {1:1}
    elif num==2:
        return {1:1,2:1}
    else:
        adict=fibtionary(num-1)
        adict[num]=adict[num-1]+adict[num-2]
        return adict

