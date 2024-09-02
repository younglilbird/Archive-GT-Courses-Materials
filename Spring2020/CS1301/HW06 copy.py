#function 1

def average_scores(examinfo):
    ave = []
    value = 0
    if examinfo =={}:
        return None
    for i in examinfo.keys():
        n = examinfo[i]
        for j in n:
            value += j
        try:
            value = value / len(n)
        except:
            value = None
        else:
            value = round(value, 2)
        ave += [(i, value)]
        value = 0
    return ave

#function 2

def class_finder(course, friend):
    n = 0
    final =[]
    for i in course.keys():
        for j in friend:
            if j in course[i]:
                n+=1
        if n>=2:
            final += [i]
        n = 0
    return final

#function 3

def security_clearance(info):
    final={}
    s={}
    for i in info:
        if i[0] in final.keys():
            if i[1] in final[i[0]].keys():
                final[i[0]][i[1]].append(i[2])
            else:
                final[i[0]][i[1]]=[i[2]]
        else:
            s[i[1]]=[i[2]]
            final[i[0]]=s
            s={}
    return final


#function 4

def find_me(people, p1, p2):
    n=0
    while p1 in people.keys():
        p1=people[p1]
        n+=1
        if p1==p2:
            return n-1
    return None

#function 5

def error_finder(num, index):
    n = 0
    ie = 0
    te = 0
    ave =0
    for i in index:
        try:
            num[i]
            if int(i)<=len(num)-1 and i>=0:
                ave += num[i]
                n+=1
        except IndexError:
            ie +=1
        except TypeError:
            te +=1
    if n == 0:
        ave =0
    else:
        ave = ave/n
    return (ave, {'IndexError': ie, 'TypeError': te})
