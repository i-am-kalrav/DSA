def bubble_sort(lst):
    n = len(lst)
    for i in range(n):
        for j in range(0, n-i-1):
            if lst[j] > lst[j+1]:
                lst[j], lst[j+1] = lst[j+1], lst[j] 
    return lst
#Worst
lst1 = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
#Avg
lst2 = [1, 3, 9, 4, 10, 2, 6, 8, 5, 7]
#Best
lst3 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

print('Worst:')
print(bubble_sort(lst1))
print('Avg:')
print(bubble_sort(lst2))
print('Best:')
print(bubble_sort(lst3))
