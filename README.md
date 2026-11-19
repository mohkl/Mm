# MUSHAF

تطبيق مصحف أندرويد يعمل بدون إنترنت (لا يحتوي على إذن INTERNET).
المطور: rFM — +201027814323

## بناء ملف APK على GitHub
1. أنشئ مستودعًا جديدًا على GitHub وارفع كل محتويات هذا المجلد.
2. افتح تبويب **Actions** ثم شغّل **Build MUSHAF APK** (أو يعمل تلقائيًا عند كل push).
3. بعد اكتمال البناء افتح التشغيل ونزّل **MUSHAF-apk** من Artifacts، ثم فك الضغط وثبّت app-debug.apk.

## إضافة المصحف الكامل
الملف الحالي app/src/main/assets/quran-data.js فيه سورتان تجريبيتان فقط (الفاتحة والإخلاص).
1. نزّل النص من tanzil.net (نوع Text, بدون تغيير على النص، والتزم بشروط الترخيص هناك).
2. حوّله:
   python tools/convert_tanzil.py quran-uthmani.txt app/src/main/assets/quran-data.js
3. ارفع التعديل وسيُبنى APK جديد.
   إذا ظهرت البسملة مكررة في أول السور عدّل الملف الناتج.
