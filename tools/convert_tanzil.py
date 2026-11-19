#!/usr/bin/env python3
"""Convert a Tanzil text file (sura|aya|text) to app/src/main/assets/quran-data.js
Usage: python tools/convert_tanzil.py quran-uthmani.txt app/src/main/assets/quran-data.js
"""
import sys, json, collections

src, dst = sys.argv[1], sys.argv[2]
data = collections.OrderedDict()
with open(src, encoding="utf-8") as f:
    for line in f:
        line = line.strip()
        if not line or line.startswith("#"):
            continue
        parts = line.split("|", 2)
        if len(parts) != 3:
            continue
        sura, _aya, text = parts
        data.setdefault(sura, []).append(text)

with open(dst, "w", encoding="utf-8") as out:
    out.write("window.QURAN=" + json.dumps(data, ensure_ascii=False) + ";")
print(len(data), "suras written to", dst)
