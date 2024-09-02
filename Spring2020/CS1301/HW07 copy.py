#function 1

def count_nominations(film,cat):
    film = open('academyawards.txt', 'r')
    n=()
    num = 0
    if cat == '':
        return ()
    text=film.readlines()
    film.close()
    for i in range(len(text)):
        if text[i] == cat+'\n' and text[i+2] == 'Winner\n':
            n =n+(text[i+1][:len(text[i+1])-1],)
            m = text[i+1][:len(text[i+1])-1]
    for j in range(len(text)):
        if m in text[j]:
            num+=1
    n+=(num,)
    
    return n

#function 2

def categories(film, clist):
    if clist==[]:
        return {}
    final={}
    flist=[]
    ftuple=()
    film=open('academyawards.txt', 'r')
    text=film.readlines()
    film.close()
    for i in clist:
        if 'Actor' in i or 'Actress' in i or 'Director' in i:
            for j in range(len(text)):
                if text[j][:len(text[j])-1] == i:
                    text[j+1]=text[j+1].split('(')
                    flist.append((text[j+1][0][:len(text[j+1][0])-1],text[j+1][1][:len(text[j+1][1])-2]))
            final[i]=flist
            flist=[]
        else:
            for l in range(len(text)):
                if text[l][:len(text[l])-1] == i:
                    ftuple=ftuple+(text[l+1][:len(text[l+1])-1],)
                    flist.append(ftuple)
                    ftuple=()
            final[i]=flist
            flist=[]
    return final

#function 3

def winner_format(film, writefile, cat):
    film=open('academyawards.txt', 'r')
    text=film.readlines()
    film.close()
    name=[]
    for i in range(len(text)):
        if text[i] == cat+'\n' and text[i+2] == 'Winner\n':
            name.append('*Winner* '+text[i+1])
        elif text[i] == cat+'\n' and text[i+2] =='Nominated\n':
            name.append(text[i+1])
    print(name)
    final=open(writefile, 'w')
    final.write(cat+'\n')
    for j in name:
        if '*' in j:
            final.write('\t1. '+j)
            name.remove(j)
    for l in range(len(name)):
        if l == len(name)-1:
            final.write('\t'+str(l+2)+'. '+name[l][:len(name[l])-1])
        else:
            final.write('\t'+str(l+2)+'. '+name[l])
    final.close()
    return final

#function 4
def data_reformatter(city, year):
    n=0
    y=0
    new=[]
    if city ==[""]:
        f2=open('homeless_population.txt', 'w')
        f2.write('1.  2006\n')
        f2.write('Homeless Population: 9871')
        f2.close()
        return f2
    if year[1]<year[0]:
        return 'Invalid Input'
    f=open('homeless_2005_2015.csv','r')
    text=f.readlines()
    f2=open('homeless_population.txt', 'w')
    for j in city:
        if j in 'New Orleans Atlanta Baton Rouge Nashville Tampa Louisville Miami Oklahoma Memphis Raleigh Benchmark':
            new.append(j)
    for u in new:
        for i in text:
            i=i.split(',')
            if u in i[0] and int(i[1])<=year[1] and int(i[1])>=year[0]:
                if int(i[4]) >=n:
                    n=int(i[4])
                    y=int(i[1])
        if new.index(u)+1 == len(new):
            f2.write(str((new.index(u)+1))+'. '+u+' '+str(y)+'\n')
            f2.write('Homeless Population: '+str(n))
            n=0
            y=0
        else:
            f2.write(str((new.index(u)+1))+'. '+u+' '+str(y)+'\n')
            f2.write('Homeless Population: '+str(n)+'\n')
            n=0
            y=0
    f2.close()
    return f2

#function 5

def homeless_rate(c1,c2,d1):
    if d1[0]<2005 or d1[1]>2015:
        return 'Invalid Input'
    if c1 not in 'New Orleans Atlanta Baton Rouge Nashville Tampa Louisville Miami Oklahoma Memphis Raleigh Benchmark' or c2 not in 'New Orleans Atlanta Baton Rouge Nashville Tampa Louisville Miami Oklahoma Memphis Raleigh Benchmark':
        return 'Invalid Input'
    if d1[0]>=d1[1]:
        return 'Invalid Input'
    n=0
    m=0
    f=open('homeless_2005_2015.csv','r')
    text=f.readlines()
    f.close()
    for i in text:
        i=i.split(',')
        if c1 in i[0] and d1[0]==int(i[1]):
            n=n-int(i[4])
        if c1 in i[0] and d1[1]==int(i[1]):
            n=n+int(i[4])
    for j in text:
        j=j.split(',')
        if c2 in j[0] and d1[0]==int(j[1]):
            m=m-int(j[4])
        if c2 in j[0] and d1[1]==int(j[1]):
            m=m+int(j[4])
    if n < m:
        return (c1, n)
    if m <= n:
        return (c2, m)
