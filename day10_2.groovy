def input="""104
83
142
123
87
48
102
159
122
69
127
151
147
64
152
90
117
132
63
109
27
47
7
52
59
11
161
12
148
155
129
10
135
17
153
96
3
93
82
55
34
65
89
126
19
72
20
38
103
146
14
105
53
77
120
39
46
24
139
95
140
33
21
84
56
1
32
31
28
4
73
128
49
18
62
81
66
121
54
160
158
138
94
43
2
114
111
110
78
13
99
108
141
40
25
154
26
35
88
76
145"""

array = input.split("\n").collect { it as int }
array = (array + 0 + (array.max() + 3)).sort()

diffs= ((0..array.size() - 2).collect { array[it + 1]-array[it] })

vier = (0..diffs.size() - 4).collect { diffs[it..it+3] }.stream().filter { it.every{it == 1} }.count() 
drei = (0..diffs.size() - 3).collect { diffs[it..it+2] }.stream().filter { it.every{it == 1} }.count() - 2 * vier
zwei = (0..diffs.size() - 2).collect { diffs[it..it+1] }.stream().filter { it.every{it == 1} }.count() - 3 * vier - 2 * drei

println ((2 as BigInteger) ** zwei * 4 ** drei * 7 ** vier )


