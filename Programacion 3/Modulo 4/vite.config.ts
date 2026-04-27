import { defineConfig } from 'vite';
import { resolve, relative } from 'path';
import { readdirSync, statSync } from 'fs';

function getHtmlEntries(baseDir: string, currentDir = baseDir): Record<string, string> {
  const entries: Record<string, string> = {};
  const items = readdirSync(currentDir);

  for (const item of items) {
    const fullPath = resolve(currentDir, item);
    const itemStats = statSync(fullPath);

    if (itemStats.isDirectory()) {
      if (fullPath === resolve(baseDir, 'dist')) {
        continue;
      }

      Object.assign(entries, getHtmlEntries(baseDir, fullPath));
      continue;
    }

    if (!item.endsWith('.html')) {
      continue;
    }

    const relativePath = relative(baseDir, fullPath).replace(/\\/g, '/');
    const entryName = relativePath.replace(/\.html$/, '');

    entries[entryName] = fullPath;
  }

  return entries;
}

export default defineConfig({
  root: 'src',
  build: {
    outDir: 'dist',
    emptyOutDir: true,
    rollupOptions: {
      input: getHtmlEntries(resolve(__dirname, 'src'))
    }
  }
});